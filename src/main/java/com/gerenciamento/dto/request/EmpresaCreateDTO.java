package com.gerenciamento.dto.request;

import com.gerenciamento.entities.Empresa;

public class EmpresaCreateDTO {

	private String nome;
	private String cnpj;
	
	public EmpresaCreateDTO() {
		
	}

	public EmpresaCreateDTO(String nome, String cnpj) {
		this.nome = nome;
		this.cnpj = cnpj;
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

}
