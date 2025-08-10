package com.gerenciamento.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gerenciamento.entities.ItemPedido;
import com.gerenciamento.entities.ItemPedidoId;

public interface ItemPedidoRepository extends JpaRepository<ItemPedido, ItemPedidoId>{

}
