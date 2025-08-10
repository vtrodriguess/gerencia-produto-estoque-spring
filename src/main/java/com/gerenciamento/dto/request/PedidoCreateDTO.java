package com.gerenciamento.dto.request;

import com.gerenciamento.entities.Pedido;

public class PedidoCreateDTO {

	private Long vendedor;
	
	public PedidoCreateDTO() {
		
	}

	public PedidoCreateDTO(Pedido pedido) {
		this.vendedor = pedido.getVendedor().getId();
	}


	public Long getVendedor() {
		return vendedor;
	}

	public void setVendedor(Long vendedor) {
		this.vendedor = vendedor;
	}

	
	
	
	

}
