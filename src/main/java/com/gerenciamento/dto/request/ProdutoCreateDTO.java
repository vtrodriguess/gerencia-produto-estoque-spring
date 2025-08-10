package com.gerenciamento.dto.request;

import com.gerenciamento.entities.Produto;

public class ProdutoCreateDTO {

	private String produto;
	private double valor;
	
	public ProdutoCreateDTO() {
		
	}
	
	public ProdutoCreateDTO(Produto produto) {
		this.produto = produto.getProduto();
		this.valor = produto.getValor();
	}
	public String getProduto() {
		return produto;
	}
	public void setProduto(String produto) {
		this.produto = produto;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	
	
	
}
