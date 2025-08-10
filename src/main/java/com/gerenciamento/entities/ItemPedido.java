package com.gerenciamento.entities;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_item_pedido")
public class ItemPedido {
	
	@EmbeddedId
	private ItemPedidoId id = new ItemPedidoId();
	
	private int quantidade;
	
	private double preco;
	
	public ItemPedido() {
		
	}

	public ItemPedido(Produto produto, Pedido pedido, int quantidade, double preco) {
		this.id.setPedido(pedido);
		this.id.setProduto(produto);
		this.quantidade = quantidade;
		this.preco = preco;
	}

	public ItemPedidoId getId() {
		return id;
	}

	public void setId(ItemPedidoId id) {
		this.id = id;
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
