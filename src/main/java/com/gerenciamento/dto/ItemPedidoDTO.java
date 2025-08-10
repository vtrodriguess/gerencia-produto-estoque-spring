package com.gerenciamento.dto;

import com.gerenciamento.entities.ItemPedido;

public class ItemPedidoDTO {

	private Long idPedido;
	private ProdutoDTO produtoDto;
	private int quantidade;
	private double preco;

	public ItemPedidoDTO() {

	}

	public ItemPedidoDTO(ItemPedido itemPedido) {
		this.idPedido = itemPedido.getId().getPedido().getId();
		this.produtoDto = new ProdutoDTO(itemPedido.getId().getProduto());
		this.quantidade = itemPedido.getQuantidade();
		this.preco = itemPedido.getPreco();
	}

	public Long getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(Long idPedido) {
		this.idPedido = idPedido;
	}

	public ProdutoDTO getProdutoDto() {
		return produtoDto;
	}

	public void setProdutoDto(ProdutoDTO produtoDto) {
		this.produtoDto = produtoDto;
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
