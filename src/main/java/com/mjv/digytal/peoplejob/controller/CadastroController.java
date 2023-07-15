package com.mjv.digytal.peoplejob.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mjv.digytal.peoplejob.model.Cadastro;
import com.mjv.digytal.peoplejob.service.CadastroService;

@RestController
@RequestMapping(value = "/cadastro")
@CrossOrigin("http://127.0.0.1:5500")
public class CadastroController {

	@Autowired
	private CadastroService service;

	@GetMapping(value = "/busca-cpf/{cpf}")
	public ResponseEntity<Cadastro> buscaCPF(@PathVariable String cpf) {
		Cadastro c = service.buscaCPF(cpf);
		return ResponseEntity.ok().body(c);
	}

	@GetMapping("/buscar-cadastros-por-data-de-nascimento")
	public ResponseEntity<List<Cadastro>> buscarCadastrosEntreDatas(LocalDate dataInicio, LocalDate dataFim) {
		return ResponseEntity.ok(service.buscarCadastrosEntreDatas(dataInicio, dataFim));
	}

	@GetMapping("/buscar-cadastros-por-cidade-e-experiencia")
	public ResponseEntity<List<Cadastro>> buscarCadastrosPorCidadeEexperiencia(String cidade) {
		return ResponseEntity.ok(service.buscarCadastrosPorCidadeEexperiencia(cidade));
	}

	@GetMapping("/buscar-cadastros-com-experiencias-entre")
	public ResponseEntity<List<Cadastro>> listarCadastrosComExperiencasEntre(LocalDate dataInicial,
			LocalDate dataFinal) {
		return ResponseEntity.ok(service.listarCadastrosComExperiencasEntre(dataInicial, dataFinal));
	}

	@GetMapping("/buscar-quantidade-de-cadastro-por-profissao")
	public ResponseEntity<Integer> buscarNumeroCadastrosPorProfissao(String profissao) {
		return ResponseEntity.ok(service.buscarNumeroCadastrosPorProfissao(profissao));
	}

	@GetMapping("/buscar-cadastros-que-trabalharam-na-empresa")
	public ResponseEntity<List<Cadastro>> listarCadastrosTrabalharamNa(String empresa) {
		return ResponseEntity.ok(service.listarCadastrosTrabalharamNa(empresa));
	}

	@GetMapping("/buscar-cadastros-que-ainda-trabalham-na-empresa")
	public ResponseEntity<List<Cadastro>> listarCadastrosQueTrabalhamNa(String empresa) {
		return ResponseEntity.ok(service.listarCadastrosQueTrabalhamNa(empresa));
	}

	@GetMapping("/buscar-cadastros-empregados-atualmente")
	public ResponseEntity<List<Cadastro>> listarCadastrosEmpregadosAtualmente() {
		return ResponseEntity.ok(service.listarCadastrosEmpregadosAtualmente());
	}

}
