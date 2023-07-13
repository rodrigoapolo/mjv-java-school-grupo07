package com.mjv.digytal.peoplejob.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
	
	@PostMapping
	public ResponseEntity<Profissao> inserirProfissao(@RequestBody Profissao profissao) {
		Profissao profissaoRetorno = profissaoService.inserirProfissao(profissao);
		return ResponseEntity.ok().body(profissaoRetorno);
	}
}
