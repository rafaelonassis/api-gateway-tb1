package com.impacta.apigatewaytb1.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.impacta.apigatewaytb1.dto.ComponenteDto;
import com.impacta.apigatewaytb1.dto.ProdutoDto;
import com.impacta.apigatewaytb1.model.ComponenteModel;
import com.impacta.apigatewaytb1.model.ProdutoModel;
import com.impacta.apigatewaytb1.service.Services;

@RestController
@RequestMapping("/api/v1/produto")
public class Controller {

	final Services services;

	public Controller(Services produtoService) {
		this.services = produtoService;
	}

	@PostMapping
	public ResponseEntity<Object> saveProduto(@RequestBody @Valid ProdutoDto produtoDto) {
		if (produtoDto.getCodigo() == null || produtoDto.getCodigo() == "") {
			return ResponseEntity.status(HttpStatus.CONFLICT).body("É nencessario preencher o código do produto");
		}
		if (produtoDto.getNome() == null || produtoDto.getNome() == "") {
			return ResponseEntity.status(HttpStatus.CONFLICT).body("É nencessario preencher o nome do produto");
		}

		if (services.existsByNome(produtoDto.getNome())) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body("Este produto ja esta cadastrado");
		}
		if (services.existsByCodigo(produtoDto.getCodigo())) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body("Este codigo de produto ja esta cadastrado");
		}
		var produtoModel = new ProdutoModel();
		BeanUtils.copyProperties(produtoDto, produtoModel);

		return ResponseEntity.status(HttpStatus.CREATED).body(services.saveProduto(produtoModel));
	}

	@GetMapping("/{codigo}")
	public ResponseEntity<Object> getProduto(@PathVariable(value = "codigo") String codigo) {
		Optional<ProdutoModel> produtoModelOptional = services.findByCodigo(codigo);
		if (!produtoModelOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto não encontrado");
		}
		return ResponseEntity.status(HttpStatus.OK).body(produtoModelOptional.get());
	}

	@GetMapping
	public ResponseEntity<Page<ProdutoModel>> getAllProduto(@PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.ASC) Pageable pageable) {
		return ResponseEntity.status(HttpStatus.OK).body(services.findAll(pageable));
	}

	@PostMapping("/{codigo}/componente")
	public ResponseEntity<Object> saveComponente(@RequestBody @Valid ComponenteDto componenteDto,@PathVariable(value = "codigo") String codigo) {
		if (codigo == null || codigo == "") {
			return ResponseEntity.status(HttpStatus.CONFLICT).body("É nencessario preencher o código do produto");
		}
		if (!services.existsByCodigo(codigo)) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body("Este codigo de produto não existe");
		}
		if (!codigo.equals(componenteDto.getCodigo())) {
			return ResponseEntity.status(HttpStatus.CONFLICT)
					.body("O codigo que esta sendo passado na URL é diferente do codigo passado no atributo");
		}

		
		if (componenteDto.getIndice() == null) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body("É nencessario preencher o indice do componente");
		}
		if (services.existsByIndice(componenteDto.getIndice())) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body("O indice é um atributo unico e o mesmo ja existe, escolha outro para este componente");
		}
		 

		if (componenteDto.getDescricao() == null || componenteDto.getDescricao() == "") {
			return ResponseEntity.status(HttpStatus.CONFLICT)
					.body("É nencessario preencher uma descrição para o componente");
		}

		var componenteModel = new ComponenteModel();
		BeanUtils.copyProperties(componenteDto, componenteModel);

		Optional<ProdutoModel> produtoModelOptional = services.findByCodigo(codigo);
		if (!produtoModelOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto não encontrado");
		} else {
			return ResponseEntity.status(HttpStatus.CREATED).body(services.saveComponente(componenteModel));
		}
	}
	
	@GetMapping("/{codigo}/componente/{indice}")
	public ResponseEntity<Object> getComponente(@PathVariable(value = "codigo") String codigo, @PathVariable(value = "indice") Long indice) {
		Optional<ComponenteModel> componenteModelResponse = services.findByCodigoEIndice(codigo, indice);
		if (!componenteModelResponse.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não foi encontrado este indice e/ou codigo");
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(componenteModelResponse.get());
	}
	
	@GetMapping("/{codigo}/componente")
	public ResponseEntity<List<ComponenteModel>> getAllComponente(@PathVariable(value = "codigo") String codigo) {
		return ResponseEntity.status(HttpStatus.OK).body(services.findByAllCodigoComponente(codigo));
	}
	
	 @GetMapping("/componente")
	    public ResponseEntity<List<ComponenteModel>> getAllComponenteDescricao(@RequestParam(value = "descricao") String descricao) {
	        List<ComponenteModel> componentes = services.findByAllDescricaoComponente(descricao);
	        return ResponseEntity.status(HttpStatus.OK).body(componentes);
	    }

}
