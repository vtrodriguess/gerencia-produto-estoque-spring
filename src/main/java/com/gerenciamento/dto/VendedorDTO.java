package com.gerenciamento.dto;

import com.gerenciamento.entities.Vendedor;

public class VendedorDTO {
	
	private Long id;
	private String nome;
	
	public VendedorDTO() {
		
	}

	public VendedorDTO(Vendedor vendedor) {
		this.id = vendedor.getId();
		this.nome = vendedor.getNome();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	

}
