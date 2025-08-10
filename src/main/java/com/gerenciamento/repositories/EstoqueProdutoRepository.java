package com.gerenciamento.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gerenciamento.entities.EstoqueProduto;
import com.gerenciamento.entities.EstoqueProdutoId;

public interface EstoqueProdutoRepository extends JpaRepository<EstoqueProduto, EstoqueProdutoId> {

}
