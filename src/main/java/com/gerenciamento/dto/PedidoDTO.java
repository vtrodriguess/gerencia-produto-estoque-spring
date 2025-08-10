package com.gerenciamento.dto;

import com.gerenciamento.entities.Pedido;

public class PedidoDTO {

	private Long id;
	private VendedorDTO vendedor;
	
	public PedidoDTO() {
		
	}
	
	public PedidoDTO(Pedido pedido) {
		this.id = pedido.getId();
		this.vendedor = new VendedorDTO(pedido.getVendedor());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public VendedorDTO getVendedor() {
		return vendedor;
	}

	public void setVendedor(VendedorDTO vendedor) {
		this.vendedor = vendedor;
	}
	
	
	
	
}
