package com.impacta.apigatewaytb1.model;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TB_COMPONENTE")
public class ComponenteModel implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;
	@Column(nullable = false)
	private String codigo;
	@Column
	private Long indice;
	@Column(length = 10)
	private int SKU;
	@Column(nullable = false)
	private String descricao;
	@Column(nullable = false)
	private double preco;
	@Column(nullable = false)
	private int quantidade;
	@ManyToOne
	private ProdutoModel produtoComponente;
	
	
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


	public Long getIndice() {
		return indice;
	}


	public void setIndice(Long indice) {
		this.indice = indice;
	}


	public int getSKU() {
		return SKU;
	}


	public void setSKU(int sKU) {
		SKU = sKU;
	}


	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	public double getPreco() {
		return preco;
	}


	public void setPreco(double preco) {
		this.preco = preco;
	}


	public int getQuantidade() {
		return quantidade;
	}


	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}


	public ProdutoModel getProdutoComponente() {
		return produtoComponente;
	}


	public void setProdutoComponente(ProdutoModel produtoComponente) {
		this.produtoComponente = produtoComponente;
	}


	public ComponenteModel() {
		super();
		// TODO Auto-generated constructor stub
	}


	public ComponenteModel(UUID id, String codigo, Long indice, int sKU, String descricao, double preco, int quantidade,
			ProdutoModel produtoComponente) {
		super();
		this.id = id;
		this.codigo = codigo;
		this.indice = indice;
		SKU = sKU;
		this.descricao = descricao;
		this.preco = preco;
		this.quantidade = quantidade;
		this.produtoComponente = produtoComponente;
	}


	
	
}
