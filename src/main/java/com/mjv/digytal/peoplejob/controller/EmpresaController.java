package com.mjv.digytal.peoplejob.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mjv.digytal.peoplejob.model.Empresa;
import com.mjv.digytal.peoplejob.service.EmpresaService;

@RestController
@RequestMapping(value = "/empresa")
public class EmpresaController {

	@Autowired
	private EmpresaService empresaService;
	
	@PostMapping
	public ResponseEntity<Empresa> inserirNovaEmpresa(@RequestBody Empresa empresa) {
		Empresa empresaRetorno = empresaService.inserirEmpresa(empresa);
		return ResponseEntity.ok().body(empresaRetorno);
	}
	
	@DeleteMapping(value = "deletar-empresa-por-id/{id}")
	public void deletarEmpresaPorId(@PathVariable Integer id) {
		empresaService.deletarEmpresaPorId(id);
	}
	
}
