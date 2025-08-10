package com.gerenciamento.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gerenciamento.dto.EmpresaDTO;
import com.gerenciamento.dto.EstoqueProdutoDTO;
import com.gerenciamento.dto.request.EmpresaCreateDTO;
import com.gerenciamento.entities.Empresa;
import com.gerenciamento.entities.EstoqueProduto;
import com.gerenciamento.service.EmpresaService;

@RestController
@RequestMapping("/empresa")
public class EmpresaController {
	
	private EmpresaService empresaService;

	public EmpresaController(EmpresaService empresaService) {
		this.empresaService = empresaService;
	}
	
	@GetMapping(value = "/listar")
	public ResponseEntity<List<EmpresaDTO>> findAll(){
		List<Empresa> empresas = empresaService.findAll();
		List<EmpresaDTO> empresasDTO = empresas.stream().map(x -> new EmpresaDTO(x)).toList();
		
		return ResponseEntity.ok(empresasDTO);
	}

	@PostMapping(value = "/cadastrar")
	public ResponseEntity <EmpresaDTO> criarEmpresa(@RequestBody EmpresaCreateDTO dto){
		Optional<Empresa> empresa = empresaService.criarEmpresa(dto.getNome(), dto.getCnpj());
		EmpresaDTO empresaDto = new EmpresaDTO(empresa.get());
		
		return ResponseEntity.ok(empresaDto);
	}
	
	@PostMapping(value = "/inserir")
	public ResponseEntity<EstoqueProdutoDTO> inserirProdutoEstoque(@RequestBody EstoqueProdutoDTO dto){
		Optional<EstoqueProduto> estoqueProduto = empresaService.inserirProdutoEstoque(dto.getIdProduto(), dto.getIdEmpresa(), dto.getQuantidade());
		EstoqueProdutoDTO estoqueProdutoDto = new EstoqueProdutoDTO(estoqueProduto.get());
		
		return ResponseEntity.ok(estoqueProdutoDto);
	}
	

}
