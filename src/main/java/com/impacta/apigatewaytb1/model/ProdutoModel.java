package com.impacta.apigatewaytb1.model;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "TB_PRODUTO")
public class ProdutoModel implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

	@Column
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String codigo;

	@Column(nullable = false, unique = true)
	private String nome;
	
	@OneToMany(mappedBy = "produtoComponente")
	private List<ComponenteModel> produtoComponente;

	public UUID getId() {
		return id;
	}


	public void setId(UUID id) {
		this.id = id;
	}


	public String getCodigo() {
		return codigo;
	}


	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public List<ComponenteModel> getProdutoComponente() {
		return produtoComponente;
	}


	public void setProdutoComponente(List<ComponenteModel> produtoComponente) {
		this.produtoComponente = produtoComponente;
	}


	public ProdutoModel() {
		super();
		// TODO Auto-generated constructor stub
	}


	public ProdutoModel(UUID id, String codigo, String nome, List<ComponenteModel> produtoComponente) {
		super();
		this.id = id;
		this.codigo = codigo;
		this.nome = nome;
		this.produtoComponente = produtoComponente;
	}

	

	
	
	

}
