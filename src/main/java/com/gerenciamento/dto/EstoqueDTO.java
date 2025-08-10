package com.gerenciamento.dto;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import com.gerenciamento.entities.Estoque;

public class EstoqueDTO {
	
	private Long id;
	private Set<EstoqueProdutoDTO> produtos = new HashSet<>();
	
	public EstoqueDTO() {
		
	}
	
	public EstoqueDTO(Estoque estoque) {
		this.id = estoque.getId();
		this.produtos = estoque.getProdutos().stream().map(x -> new EstoqueProdutoDTO(x)).collect(Collectors.toSet());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Set<EstoqueProdutoDTO> getProdutos() {
		return produtos;
	}

	public void setProdutos(Set<EstoqueProdutoDTO> produtos) {
		this.produtos = produtos;
	}
	
	

}
