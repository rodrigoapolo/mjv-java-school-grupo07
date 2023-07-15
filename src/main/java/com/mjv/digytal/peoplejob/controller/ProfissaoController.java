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

import com.mjv.digytal.peoplejob.dto.CandidatoProfissaoView;
import com.mjv.digytal.peoplejob.dto.ProfissaoCandidatoView;
import com.mjv.digytal.peoplejob.dto.QuantidadeProfissaoPorCidadeView;
import com.mjv.digytal.peoplejob.dto.QuantidadeProfissionalView;
import com.mjv.digytal.peoplejob.model.Profissao;
import com.mjv.digytal.peoplejob.service.ProfissaoService;


@RestController
@RequestMapping(value = "/profissao")
public class ProfissaoController {

	@Autowired
	private ProfissaoService profissaoService;
	
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
	
	@GetMapping(value = "/agrupar-profissao-por-cidade/{cidade}")
	public ResponseEntity<List<QuantidadeProfissaoPorCidadeView>> agruparProfissaoCidade(@PathVariable String cidade) {
		List<QuantidadeProfissaoPorCidadeView> profissaoQuantidadeCidade = profissaoService.agruparProfissaoCidade(cidade);
		return ResponseEntity.ok().body(profissaoQuantidadeCidade);
	}

	@GetMapping(value = "/profissao-candidato")
	public ResponseEntity<List<ProfissaoCandidatoView>> buscarProfissaoCandidato() {
		List<ProfissaoCandidatoView> profissaoCandidato = profissaoService.buscarCandidatosProfissao();
		return ResponseEntity.ok().body(profissaoCandidato);
	}

	@GetMapping(value = "/contar-profissao")
	public ResponseEntity<List<QuantidadeProfissionalView>> contarProfissao() {
		List<QuantidadeProfissionalView> quantidadeProfissional = profissaoService.contarProfissao();
		return ResponseEntity.ok().body(quantidadeProfissional);
	}

	@GetMapping(value = "/buscar-nome-profissao-candidato/{profissao}")
	public ResponseEntity<List<CandidatoProfissaoView>> buscarNomeProfissaoCandidato(@PathVariable("profissao") String profissao) {
		List<CandidatoProfissaoView> quantidadeProfissional = profissaoService.nomeProfissaoCandidatos(profissao);
		return ResponseEntity.ok().body(quantidadeProfissional);
	}
}
