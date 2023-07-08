package com.mjv.digytal.peoplejob.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mjv.digytal.peoplejob.model.Cadastro;
import com.mjv.digytal.peoplejob.service.CadastroService;

@RestController
@RequestMapping(value = "/cadastro")
public class CadastroController {

	@Autowired
	private CadastroService service;

	@GetMapping(value = "/busca-cpf/{cpf}")
	public ResponseEntity<Cadastro> buscaCPF(@PathVariable String cpf) {
		Cadastro c = service.buscaCPF(cpf);
		return ResponseEntity.ok().body(c);
	}

	@GetMapping("/buscar-por-data-de-nascimento")
	public ResponseEntity<List<Cadastro>> buscarCadastroPorData() {
		return ResponseEntity.ok(service.buscar_candidatos_entre_anos_oitenta_a_vinte_e_tres());
	}

	@GetMapping("/buscar-cadastro-por-cidade")
	public ResponseEntity<List<Cadastro>> buscar_candidato_por_cidade_e_experiencia() {
		return ResponseEntity.ok(service.buscar_candidato_por_cidade_e_experiencia());
	}

	@GetMapping("/buscar-cadastro-por-profissao")
	public ResponseEntity<Integer> buscar_analista_de_sistemas() {
		return ResponseEntity.ok(service.buscar_analista_de_sistemas());
	}

}
