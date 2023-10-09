package com.impacta.apigatewaytb1.dto;

public class ComponenteDto {
	
	private String codigo;
	
	private Long indice;
	
	private int SKU;
	
	private String descricao;
	
	private double preco;
	
	private int quantidade;
	
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
	

}
