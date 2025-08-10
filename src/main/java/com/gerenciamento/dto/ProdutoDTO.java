package com.gerenciamento.dto;

import com.gerenciamento.entities.Estoque;
import com.gerenciamento.entities.Produto;

public class ProdutoDTO {
	
	private Long id;
	private String produto;
	private double valor;
	
	public ProdutoDTO() {

	}
	
	public ProdutoDTO(Produto prod) {
		this.id = prod.getId();
		this.produto = prod.getProduto();
		this.valor = prod.getValor();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
