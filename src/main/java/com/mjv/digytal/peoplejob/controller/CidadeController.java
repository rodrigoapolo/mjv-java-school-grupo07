package com.mjv.digytal.peoplejob.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mjv.digytal.peoplejob.model.Cidade;
import com.mjv.digytal.peoplejob.service.CidadeService;

@RestController
@RequestMapping(value = "/cidade")
public class CidadeController {

	@Autowired
	private CidadeService cidadeService;
	
	@PostMapping
	public ResponseEntity<Cidade> inserirNovaProfissao(@RequestBody Cidade cidade) {
		Cidade cidadeRetorno = cidadeService.inserirCidade(cidade);
		return ResponseEntity.ok().body(cidadeRetorno);
	}
	
    @DeleteMapping(value = "deletar-cidade-por-id/{id}")
	public void deletarCidadePorId(@PathVariable Integer id) {
		cidadeService.deletarCidadePorId(id);
	}
	
}
