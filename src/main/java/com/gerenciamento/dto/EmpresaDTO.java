package com.gerenciamento.dto;

import com.gerenciamento.entities.Empresa;
import com.gerenciamento.entities.Estoque;

public class EmpresaDTO {

	private Long id;
	private String nome;
	private String cnpj;
	private EstoqueDTO estoque;

	public EmpresaDTO() {

	}

	public EmpresaDTO(Empresa empresa) {
		this.id = empresa.getId();
		this.nome = empresa.getNome();
		this.cnpj = empresa.getCnpj();
		this.estoque = new EstoqueDTO(empresa.getEstoque());
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

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public EstoqueDTO getEstoque() {
		return estoque;
	}

	public void setEstoque(EstoqueDTO estoque) {
		this.estoque = estoque;
	}

	

}
