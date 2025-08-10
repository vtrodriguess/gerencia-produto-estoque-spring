package com.gerenciamento.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.gerenciamento.entities.Empresa;
import com.gerenciamento.entities.Estoque;
import com.gerenciamento.entities.EstoqueProduto;
import com.gerenciamento.entities.EstoqueProdutoId;
import com.gerenciamento.entities.ItemPedido;
import com.gerenciamento.entities.Pedido;
import com.gerenciamento.entities.Produto;
import com.gerenciamento.entities.Vendedor;
import com.gerenciamento.repositories.EmpresaRepository;
import com.gerenciamento.repositories.EstoqueProdutoRepository;
import com.gerenciamento.repositories.ItemPedidoRepository;
import com.gerenciamento.repositories.PedidoRepository;
import com.gerenciamento.repositories.ProdutoRepository;
import com.gerenciamento.repositories.VendedorRepository;

@Service
public class VendedorService {

	private PedidoRepository pedidoRepository;
	private ProdutoRepository produtoRepository;
	private ItemPedidoRepository itemPedidoRepository;
	private VendedorRepository vendedorRepository;
	private EmpresaRepository empresaRepository;
	private EstoqueProdutoRepository estoqueProdutoRepository;

	public VendedorService(PedidoRepository pedidoRepository, ProdutoRepository produtoRepository,
			ItemPedidoRepository itemPedidoRepository, VendedorRepository vendedorRepository,
			EmpresaRepository empresaRepository, EstoqueProdutoRepository estoqueProdutoRepository) {
		this.pedidoRepository = pedidoRepository;
		this.produtoRepository = produtoRepository;
		this.itemPedidoRepository = itemPedidoRepository;
		this.vendedorRepository = vendedorRepository;
		this.empresaRepository = empresaRepository;
		this.estoqueProdutoRepository = estoqueProdutoRepository;
	}

	public Optional<Vendedor> cadastrarVendedor(String nome) {
		Vendedor vendedor = new Vendedor(nome);

		return Optional.of(vendedorRepository.save(vendedor));
	}

	public Optional<Pedido> cadastrarPedido(Long idVendedor) {
		Optional<Vendedor> vendedor = vendedorRepository.findById(idVendedor);

		Pedido pedido = new Pedido();
		pedido.setVendedor(vendedor.get());
		pedidoRepository.save(pedido);

		return Optional.of(pedido);

	}

	public Optional<ItemPedido> inserirItens(Long idPedido, Long idEmpresa, Long idProduto, int quantidade,
			double preco) {
		Optional<Empresa> empresa = empresaRepository.findById(idEmpresa);
		Optional<Produto> produto = produtoRepository.findById(idProduto);
		EstoqueProdutoId estoqueProdutoId = new EstoqueProdutoId(produto.get(), empresa.get().getEstoque());
		Optional<EstoqueProduto> estoqueProduto = estoqueProdutoRepository.findById(estoqueProdutoId);
		Optional<Pedido> pedido = pedidoRepository.findById(idPedido);

		if (estoqueProduto.isPresent() && pedido.isPresent()) {
			if (estoqueProduto.get().getQuantidade() >= quantidade) {
				ItemPedido itens = new ItemPedido(produto.get(), pedido.get(), quantidade, preco);
				itemPedidoRepository.save(itens);

				return Optional.of(itens);
			}
		}

		return Optional.empty();
	}

}
