package com.mjv.digytal.peoplejob.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mjv.digytal.peoplejob.dto.view.CadastroView;
import com.mjv.digytal.peoplejob.model.Experiencia;
import com.mjv.digytal.peoplejob.service.ExperienciaService;

@RestController
@RequestMapping(value = "/experiencia")
public class ExperienciaController {

	@Autowired
	private ExperienciaService experienciaService;

	@GetMapping(value = "/buscar-nao-trabalhando/{empregoAtual}")
	public ResponseEntity<List<CadastroView>> imprimirNaoTrabalhando(@PathParam("empregoAtual") boolean empregoAtual) {
		List<CadastroView> candidatosNaoTrabalhando = experienciaService.imprimirNaoTrabalhando(empregoAtual);
		return ResponseEntity.ok().body(candidatosNaoTrabalhando);
	}

	@PostMapping
	public ResponseEntity<Experiencia> inserirExperiencia(@RequestBody Experiencia experiencia) {
		Experiencia experienciaCriada = experienciaService.inserirExperiencia(experiencia);
		return ResponseEntity.ok().body(experienciaCriada);
	}
	
	@DeleteMapping(value = "deletar-experiencia-por-id/{id}")
	public void deletarExperienciaPorId(@PathVariable Integer id) {
		experienciaService.deletarExperienciaPorId(id);
	}
}
