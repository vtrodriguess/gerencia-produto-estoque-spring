package com.gerenciamento.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.gerenciamento.entities.Empresa;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {
	
	@Query("SELECT e FROM Empresa e LEFT JOIN FETCH e.estoque")
	List<Empresa> findAllWithEstoque();

}
