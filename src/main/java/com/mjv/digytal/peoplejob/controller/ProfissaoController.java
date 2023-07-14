package com.mjv.digytal.peoplejob.controller;

import java.util.List;

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

import com.mjv.digytal.peoplejob.dto.view.CadastroViewProfissao;
import com.mjv.digytal.peoplejob.model.Profissao;
import com.mjv.digytal.peoplejob.service.ProfissaoService;


@RestController
@RequestMapping(value = "/profissao")
public class ProfissaoController {

	@Autowired
	private ProfissaoService profissaoService;

	@GetMapping(value = "/buscar-exceto-profissao")
	public ResponseEntity<List<CadastroViewProfissao>> imprimirCandidatosExcetoProfissao(String nome) {
		List<CadastroViewProfissao> candidatosNaoAnalistas = profissaoService.imprimirCandidatosExcetoProfissao(nome);
		return ResponseEntity.ok().body(candidatosNaoAnalistas);
	}
	
	@GetMapping(value = "/buscar-por-id/{id}")
	public ResponseEntity<Profissao> buscarPorId(@PathVariable Integer id) {
		Profissao profissaoBusca = profissaoService.buscarPorId(id).get();
		return ResponseEntity.ok().body(profissaoBusca);
	}
	
	@PutMapping(value = "/atualizar/{id}")
	public ResponseEntity<Profissao> atualizarProfissao(@PathVariable Integer id, @RequestBody Profissao profissao) {
		Profissao profissaoAtualizada = profissaoService.atualizarProfissao(id, profissao);
		return ResponseEntity.ok().body(profissaoAtualizada);
	}
	
	@PostMapping(value = "/inserir")
	public ResponseEntity<Profissao> inserirProfissao(@RequestBody Profissao profissao) {
		Profissao profissaoRetorno = profissaoService.inserirProfissao(profissao);
		return ResponseEntity.ok().body(profissaoRetorno);
	}
	
	@DeleteMapping(value = "/deletar-por-id/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletarProfissaoPorId(@PathVariable Integer id) {
		profissaoService.deletarProfissaoPorId(id);
	}
}
