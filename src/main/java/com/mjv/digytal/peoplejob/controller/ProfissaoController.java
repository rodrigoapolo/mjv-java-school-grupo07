package com.mjv.digytal.peoplejob.controller;

import java.util.List;

import com.mjv.digytal.peoplejob.dto.view.QuantidadeProfissaoPorCidadeView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
	public ResponseEntity<Profissao> inserirNovaProfissao(@RequestBody Profissao profissao) {
		Profissao profissaoRetorno = profissaoService.inserirProfissao(profissao);
		return ResponseEntity.ok().body(profissaoRetorno);
	}

	@GetMapping(value = "/agrupar-profissao-por-cidade/{cidade}")
	public ResponseEntity<List<QuantidadeProfissaoPorCidadeView>> agruparProfissaoCidade(@PathVariable String cidade) {
		List<QuantidadeProfissaoPorCidadeView> profissaoQuantidadeCidade = profissaoService.agruparProfissaoCidade(cidade);
		return ResponseEntity.ok().body(profissaoQuantidadeCidade);
	}
}
