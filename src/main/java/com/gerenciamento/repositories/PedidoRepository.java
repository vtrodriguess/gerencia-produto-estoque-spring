package com.gerenciamento.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gerenciamento.entities.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

}
