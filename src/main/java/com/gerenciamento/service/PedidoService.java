package com.gerenciamento.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.gerenciamento.entities.ItemPedido;
import com.gerenciamento.entities.Pedido;
import com.gerenciamento.entities.Produto;
import com.gerenciamento.entities.Vendedor;
import com.gerenciamento.repositories.EmpresaRepository;
import com.gerenciamento.repositories.ItemPedidoRepository;
import com.gerenciamento.repositories.PedidoRepository;
import com.gerenciamento.repositories.ProdutoRepository;
import com.gerenciamento.repositories.VendedorRepository;

@Service
public class PedidoService {

	private PedidoRepository pedidoRepository;

	public PedidoService(PedidoRepository pedidoRepository) {
		this.pedidoRepository = pedidoRepository;
	}

	public Optional<Pedido> findById(Long id) {
		return pedidoRepository.findById(id);
	}

	public List<Pedido> findAll() {
		return pedidoRepository.findAll();
	}

}
