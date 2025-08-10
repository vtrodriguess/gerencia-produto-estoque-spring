package com.gerenciamento.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gerenciamento.entities.Estoque;

public interface EstoqueRepository extends JpaRepository<Estoque, Long>{

}
