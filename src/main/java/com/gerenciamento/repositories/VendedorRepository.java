package com.gerenciamento.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gerenciamento.entities.Vendedor;

public interface VendedorRepository extends JpaRepository<Vendedor, Long> {

}
