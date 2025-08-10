package com.gerenciamento.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gerenciamento.entities.Produto;
import com.gerenciamento.repositories.ProdutoRepository;

@Service
public class ProdutoService {

	private ProdutoRepository produtoRepository;

	public ProdutoService(ProdutoRepository produtoRepository) {
		this.produtoRepository = produtoRepository;
	}
	
	@Transactional(readOnly = true)
	public List<Produto> findAll() {
		return produtoRepository.findAll();
	}

	public Optional<Produto> cadastrarProduto(String nome, double valor) {
		Produto produto = new Produto();

		produto.setProduto(nome);
		produto.setValor(valor);

		return Optional.of(produtoRepository.save(produto));
	}
	
}
