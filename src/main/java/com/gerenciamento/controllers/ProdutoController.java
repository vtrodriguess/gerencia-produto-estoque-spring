package com.gerenciamento.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gerenciamento.dto.ProdutoDTO;
import com.gerenciamento.dto.request.ProdutoCreateDTO;
import com.gerenciamento.entities.Produto;
import com.gerenciamento.service.ProdutoService;

@RestController
@RequestMapping("/produto")
public class ProdutoController {
	
	private ProdutoService produtoService;

	public ProdutoController(ProdutoService produtoService) {
		this.produtoService = produtoService;
	}
	
	@GetMapping(value = "/listar")
	public ResponseEntity<List<ProdutoDTO>> findAllProd(){
		List<Produto> produtos = produtoService.findAll();
		List<ProdutoDTO> produtoDTO = produtos.stream().map(x -> new ProdutoDTO(x)).toList();
		
		return ResponseEntity.ok(produtoDTO);
	}
	
	@PostMapping(value = "/cadastrar")
	public ResponseEntity <ProdutoCreateDTO> criarProduto(@RequestBody ProdutoCreateDTO dto){
		Optional<Produto> produto = produtoService.cadastrarProduto(dto.getProduto(), dto.getValor());
		ProdutoCreateDTO produtoDto = new ProdutoCreateDTO(produto.get());
		
		return ResponseEntity.ok(produtoDto);
	}
	

}
