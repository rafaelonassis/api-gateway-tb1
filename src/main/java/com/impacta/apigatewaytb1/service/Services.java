package com.impacta.apigatewaytb1.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.impacta.apigatewaytb1.model.ComponenteModel;
import com.impacta.apigatewaytb1.model.ProdutoModel;
import com.impacta.apigatewaytb1.repositories.ComponenteRepository;
import com.impacta.apigatewaytb1.repositories.ProdutoRepository;


@Service
public class Services {
	
	final ProdutoRepository produtoRepository;
	final ComponenteRepository componenteRepository;

	public Services(ProdutoRepository produtoRepository, ComponenteRepository componenteRepository) {
		this.produtoRepository = produtoRepository;
		this.componenteRepository = componenteRepository;
	}
	
	public boolean existsByNome(String nome) {
        return produtoRepository.existsByNome(nome);
    }
	
	public boolean existsByCodigo(String codigo) {
        return produtoRepository.existsByCodigo(codigo);
    }
	
	public boolean existsByIndice(Long indice) {
        return componenteRepository.existsByIndice(indice);
    }
	
	public Optional<ProdutoModel> findByCodigo(String codigo) {
        return produtoRepository.findByCodigo(codigo);
    }
	
	public Optional<ComponenteModel> findByCodigoComponente(String codigo) {
        return componenteRepository.findByCodigo(codigo);
    }
	
	public Optional<ComponenteModel> findByCodigoEIndice(String codigo, Long indice) {
        return componenteRepository.findByCodigoEIndice(codigo, indice);
    }
	
	public Page<ProdutoModel> findAll(Pageable pageable) {
        return produtoRepository.findAll(pageable);
    }
	
	@Transactional
    public ProdutoModel saveProduto(ProdutoModel produtoModel) {
        return produtoRepository.save(produtoModel);
    }
	
	@Transactional
    public ComponenteModel saveComponente(ComponenteModel componenteModel) {
        return componenteRepository.save(componenteModel);
    }

	public List<ComponenteModel> findByAllCodigoComponente(String codigo) {
		return componenteRepository.findByCodigoTodas(codigo);
	}

	public List<ComponenteModel> findByAllDescricaoComponente(String descricao) {
		return componenteRepository.findByAllDescricaoComponente(descricao);
	}

}
