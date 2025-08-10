package com.gerenciamento.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.gerenciamento.entities.Produto;
import com.gerenciamento.repositories.EstoqueRepository;
import com.gerenciamento.repositories.ProdutoRepository;

@Service
public class EstoqueService {

	private EstoqueRepository estoqueRepository;
	private ProdutoRepository produtoRepository;
	
	public EstoqueService(EstoqueRepository estoqueRepository, ProdutoRepository produtoRepository) {
		this.estoqueRepository = estoqueRepository;
		this.produtoRepository = produtoRepository;
	}
	
	public Set<Produto> produtosCadastrados (){
		 return new HashSet<>(produtoRepository.findAll());
	}
	
	
}
