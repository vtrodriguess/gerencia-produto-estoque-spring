package com.gerenciamento.dto.request;

import com.gerenciamento.entities.ItemPedido;

public class ItemPedidoCreateDTO {

	private Long idPedido;
	private Long idEmpresa;
	private Long idProduto;
	private int quantidade;
	private double preco;

	public ItemPedidoCreateDTO() {
		
	}

	public ItemPedidoCreateDTO(Long idPedido, Long idEmpresa, Long idProduto, int quantidade, double preco) {
		this.idPedido = idPedido;
		this.idEmpresa = idEmpresa;
		this.idProduto = idProduto;
		this.quantidade = quantidade;
		this.preco = preco;
	}

	public Long getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(Long idPedido) {
		this.idPedido = idPedido;
	}

	public Long getIdEmpresa() {
		return idEmpresa;
	}

	public void setIdEmpresa(Long idEmpresa) {
		this.idEmpresa = idEmpresa;
	}

	public Long getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(Long idProduto) {
		this.idProduto = idProduto;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}
	
	

}
