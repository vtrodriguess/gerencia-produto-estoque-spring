package com.gerenciamento.controllers;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gerenciamento.dto.ItemPedidoDTO;
import com.gerenciamento.dto.PedidoDTO;
import com.gerenciamento.dto.VendedorDTO;
import com.gerenciamento.dto.request.ItemPedidoCreateDTO;
import com.gerenciamento.dto.request.PedidoCreateDTO;
import com.gerenciamento.entities.ItemPedido;
import com.gerenciamento.entities.Pedido;
import com.gerenciamento.entities.Vendedor;
import com.gerenciamento.service.VendedorService;

@RestController
@RequestMapping("/vendedor")
public class VendedorController {
	
	private VendedorService vendedorService;
	
	@PostMapping("/cadastrar-vendedor")
	public ResponseEntity<VendedorDTO> cadastrarVendedor(@RequestBody String nome){
		Optional<Vendedor> vendedor = vendedorService.cadastrarVendedor(nome);
		VendedorDTO vendedorDto = new VendedorDTO(vendedor.get());
		
		return ResponseEntity.ok(vendedorDto);
		
	}
	
	@PostMapping("/cadastrar-pedido")
	public ResponseEntity<PedidoDTO> cadastrarPedido(@RequestBody PedidoCreateDTO dto){
		Optional<Pedido> pedido = vendedorService.cadastrarPedido(dto.getVendedor());
		PedidoDTO pedidoDto = new PedidoDTO(pedido.get());
		
		return ResponseEntity.ok(pedidoDto);
		
	}
	
	@PostMapping("/inserir-item")
	public ResponseEntity<ItemPedidoDTO> inserirItem(@RequestBody ItemPedidoCreateDTO dto){
		Optional <ItemPedido> itemPedido = vendedorService.inserirItens(dto.getIdPedido(), dto.getIdEmpresa(), 
				dto.getIdProduto(), dto.getQuantidade(), dto.getPreco());
		ItemPedidoDTO itemPedidoDto = new ItemPedidoDTO(itemPedido.get());
		
		return ResponseEntity.ok(itemPedidoDto);
	}

}
