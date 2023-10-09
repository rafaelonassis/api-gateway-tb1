package com.impacta.apigatewaytb1.repositories;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.impacta.apigatewaytb1.model.ComponenteModel;

public interface ComponenteRepository extends JpaRepository<ComponenteModel, UUID> {

	boolean existsByIndice(Long indice);
	
	public Optional<ComponenteModel> findByCodigo(String codigo);
	
	@Query("select c from ComponenteModel c where c.codigo like :codigo")
	public List<ComponenteModel> findByCodigoTodas(String codigo);
	
	@Query("select c from ComponenteModel c where c.codigo like :codigo and c.indice = :indice")
	public Optional<ComponenteModel> findByCodigoEIndice(String codigo, Long indice);

	@Query("select c from ComponenteModel c where c.descricao like %:descricao%")
	public List<ComponenteModel> findByAllDescricaoComponente(String descricao);
}
