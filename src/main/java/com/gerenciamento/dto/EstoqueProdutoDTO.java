package com.gerenciamento.dto;

import com.gerenciamento.entities.EstoqueProduto;

public class EstoqueProdutoDTO {
	
	private Long idProduto;
	private Long idEmpresa;
	private int quantidade;
	
	public EstoqueProdutoDTO() {
		
	}

	public EstoqueProdutoDTO(EstoqueProduto estoqueProduto) {
		this.idProduto = estoqueProduto.getProduto().getId();
		this.idEmpresa = estoqueProduto.getEstoque().getEmpresa().getId();
		this.quantidade = estoqueProduto.getQuantidade();
	}

	public Long getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(Long idProduto) {
		this.idProduto = idProduto;
	}

	public Long getIdEmpresa() {
		return idEmpresa;
	}

	public void setIdEmpresa(Long idEmpresa) {
		this.idEmpresa = idEmpresa;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
	

}
