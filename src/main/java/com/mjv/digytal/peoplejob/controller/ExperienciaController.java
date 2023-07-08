package com.mjv.digytal.peoplejob.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mjv.digytal.peoplejob.dto.view.CadastroView;
import com.mjv.digytal.peoplejob.model.Cadastro;
import com.mjv.digytal.peoplejob.model.Experiencia;
import com.mjv.digytal.peoplejob.service.ExperienciaService;

@RestController
@RequestMapping(value = "/experiencia")
public class ExperienciaController {

	@Autowired
	private ExperienciaService experienciaService;

	@GetMapping(value = "/buscar-nao-trabalhando/{empregoAtual}")
	public List<CadastroView> imprimirNaoTrabalhando(@PathParam("empregoAtual") boolean empregoAtual) {
		List<CadastroView> candidatosNaoTrabalhando = experienciaService.imprimirNaoTrabalhando(empregoAtual);
		return candidatosNaoTrabalhando;
	}

}
