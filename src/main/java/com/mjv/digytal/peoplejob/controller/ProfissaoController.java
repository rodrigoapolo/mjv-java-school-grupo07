package com.mjv.digytal.peoplejob.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mjv.digytal.peoplejob.dto.view.CadastroViewProfissao;
import com.mjv.digytal.peoplejob.service.ProfissaoService;

@RestController
@RequestMapping(value = "/profissao")
public class ProfissaoController {

	@Autowired
	private ProfissaoService profissaoService;

	@GetMapping(value = "/buscar-nao-analista")
	public ResponseEntity<List<CadastroViewProfissao>> imprimirNaoTrabalhando() {
		List<CadastroViewProfissao> candidatosNaoAnalistas = profissaoService.imprimirNaoAnalistaDeSistemas();
		return ResponseEntity.ok().body(candidatosNaoAnalistas);
	}
}