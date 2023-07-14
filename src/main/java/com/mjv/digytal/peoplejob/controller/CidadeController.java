package com.mjv.digytal.peoplejob.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.mjv.digytal.peoplejob.model.Cidade;
import com.mjv.digytal.peoplejob.service.CidadeService;

@RestController
@RequestMapping(value = "/cidade")
public class CidadeController {

	@Autowired
	private CidadeService cidadeService;
	
	@GetMapping(value = "/buscar-por-id/{id}")
	public ResponseEntity<Cidade> buscarPorId(@PathVariable Integer id) {
		Cidade cidadeBusca = cidadeService.buscarPorId(id).get();
		return ResponseEntity.ok().body(cidadeBusca);
	}
	
	@PostMapping(value = "/inserir")
	public ResponseEntity<Cidade> inserirCidade(@RequestBody Cidade cidade) {
		Cidade cidadeRetorno = cidadeService.inserirCidade(cidade);
		return ResponseEntity.ok().body(cidadeRetorno);
	}
	
	@PutMapping(value = "/atualizar/{id}")
	public ResponseEntity<Cidade> atualizarCidade(@PathVariable Integer id, @RequestBody Cidade cidade) {
		Cidade cidadeAtualizada = cidadeService.atualizarCidade(id, cidade);
		return ResponseEntity.ok().body(cidadeAtualizada);
	}
	
    @DeleteMapping(value = "/deletar-por-id/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletarCidadePorId(@PathVariable Integer id) {
		cidadeService.deletarCidadePorId(id);
	}
	
}
