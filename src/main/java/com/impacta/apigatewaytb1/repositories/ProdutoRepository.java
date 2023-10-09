package com.impacta.apigatewaytb1.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.impacta.apigatewaytb1.model.ProdutoModel;

@Repository
public interface ProdutoRepository extends JpaRepository<ProdutoModel, UUID> {

	boolean existsByNome(String nome);
	
	boolean existsByCodigo(String codigo);
	
	public Optional<ProdutoModel> findByCodigo(String codigo);

}
