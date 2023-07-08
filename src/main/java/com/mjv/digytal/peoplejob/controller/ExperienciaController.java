package com.mjv.digytal.peoplejob.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mjv.digytal.peoplejob.model.Experiencia;
import com.mjv.digytal.peoplejob.service.ExperienciaService;

@RestController
@RequestMapping(value = "/experiencia")
public class ExperienciaController {

	@Autowired
	private ExperienciaService experienciaService;

	@GetMapping(value = "/buscar-nao-trabalhando/{empregoAtual}")
	public List<Experiencia> imprimirNaoTrabalhando(@PathVariable boolean empregoAtual) {

		List<Experiencia> candidatosNaoTrabalhando = experienciaService.imprimirNaoTrabalhando(empregoAtual);

		return candidatosNaoTrabalhando;
		
	}

}
