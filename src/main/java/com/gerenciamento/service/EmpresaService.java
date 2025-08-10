package com.gerenciamento.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gerenciamento.entities.Empresa;
import com.gerenciamento.entities.Estoque;
import com.gerenciamento.entities.EstoqueProduto;
import com.gerenciamento.entities.EstoqueProdutoId;
import com.gerenciamento.entities.ItemPedido;
import com.gerenciamento.entities.Pedido;
import com.gerenciamento.entities.Produto;
import com.gerenciamento.repositories.EmpresaRepository;
import com.gerenciamento.repositories.EstoqueProdutoRepository;
import com.gerenciamento.repositories.EstoqueRepository;
import com.gerenciamento.repositories.PedidoRepository;
import com.gerenciamento.repositories.ProdutoRepository;

@Service
public class EmpresaService {

	private PedidoRepository pedidoRepository;
	private ProdutoRepository produtoRepository;
	private EmpresaRepository empresaRepository;
	private EstoqueProdutoRepository estoqueProdutoRepository;
	private EstoqueRepository estoqueRepository;

	public EmpresaService(PedidoRepository pedidoRepository, ProdutoRepository produtoRepository,
			EmpresaRepository empresaRepository, EstoqueProdutoRepository estoqueProdutoRepository,
			EstoqueRepository estoqueRepository) {
		this.pedidoRepository = pedidoRepository;
		this.produtoRepository = produtoRepository;
		this.empresaRepository = empresaRepository;
		this.estoqueProdutoRepository = estoqueProdutoRepository;
		this.estoqueRepository = estoqueRepository;
	}

	public Optional<Empresa> criarEmpresa(String nome, String cnpj) {
		Estoque estoque = new Estoque();
		Empresa empresa = new Empresa(nome, cnpj, estoque);
		estoque.setEmpresa(empresa);

		return Optional.of(empresaRepository.save(empresa));
	}

	@Transactional(readOnly = true)
	public List<Empresa> findAll() {
		return empresaRepository.findAllWithEstoque();
	}

	public Optional<EstoqueProduto> inserirProdutoEstoque(Long idProduto, Long idEmpresa, int quantidade){
		Optional<Produto> produto = produtoRepository.findById(idProduto);
		Optional<Empresa> empresa = empresaRepository.findById(idEmpresa);
		Estoque estoque = empresa.get().getEstoque();
		Produto addProduto = produto.get();
		EstoqueProdutoId estoqueProdutoId = new EstoqueProdutoId(addProduto, estoque);

		if (estoqueProdutoRepository.findById(estoqueProdutoId).isPresent()) {
			return Optional.empty();
		} else {
			EstoqueProduto estoqueProduto = new EstoqueProduto(estoque, addProduto, quantidade);
			return Optional.of(estoqueProdutoRepository.save(estoqueProduto));
		}

	}

	public Optional<EstoqueProduto> attEstoque(Long idProduto, int quantidade, Long idEmpresa) {
		Optional<Produto> produto = produtoRepository.findById(idProduto);
		Optional<Empresa> empresa = empresaRepository.findById(idEmpresa);
		Estoque estoque = empresa.get().getEstoque();
		Produto addProduto = produto.get();

		EstoqueProdutoId estoqueProdutoId = new EstoqueProdutoId(addProduto, estoque);
		Optional<EstoqueProduto> estoqueProduto = estoqueProdutoRepository.findById(estoqueProdutoId);

		if (estoqueProduto.isPresent()) {
			EstoqueProduto att = estoqueProduto.get();
			att.setQuantidade(att.getQuantidade() + quantidade);
			return Optional.of(estoqueProdutoRepository.save(att));
		}

		return Optional.empty();

	}

	public void faturarPedido(Long idPedido, Long idProduto, Long idEmpresa) {
		Optional<Pedido> pedido = pedidoRepository.findById(idPedido);
		Optional<Empresa> empresa = empresaRepository.findById(idEmpresa);

		Estoque estoque = empresa.get().getEstoque();

		List<ItemPedido> itens = pedido.get().getItensPedido();
		for (ItemPedido item : itens) {
			Produto produtoItem = item.getId().getProduto();
			EstoqueProdutoId estoqueProdutoId = new EstoqueProdutoId(produtoItem, estoque);
			Optional<EstoqueProduto> estoqueProduto = estoqueProdutoRepository.findById(estoqueProdutoId);
			if (estoqueProduto.isPresent()) {
				EstoqueProduto att = estoqueProduto.get();
				att.setQuantidade(att.getQuantidade() - item.getQuantidade());
				estoqueProdutoRepository.save(att);
			}
		}

		pedidoRepository.deleteById(idPedido);
	}

}
