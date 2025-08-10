package com.gerenciamento.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gerenciamento.entities.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
