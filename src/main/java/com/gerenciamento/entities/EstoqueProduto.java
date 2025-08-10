package com.gerenciamento.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_estoqueproduto")
public class EstoqueProduto {

	@EmbeddedId
	private EstoqueProdutoId id = new EstoqueProdutoId();

	@Column(name = "quantidade")
	private int quantidade;

	public EstoqueProduto() {

	}

	public EstoqueProduto(Estoque estoque, Produto produto, int quantidade) {
		this.id.setEstoque(estoque);
		this.id.setProduto(produto);
		this.quantidade = quantidade;
	}

	public Estoque getEstoque() {
		return id.getEstoque();
	}

	public void setEstoque(Estoque estoque) {
		id.setEstoque(estoque);
	}

	public Produto getProduto() {
		return id.getProduto();
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

}
