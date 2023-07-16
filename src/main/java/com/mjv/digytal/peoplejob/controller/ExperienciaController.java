package com.mjv.digytal.peoplejob.controller;

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

import com.mjv.digytal.peoplejob.model.Experiencia;
import com.mjv.digytal.peoplejob.service.ExperienciaService;

@RestController
@RequestMapping(value = "/api/v1/experiencia")
public class ExperienciaController {

	@Autowired
	private ExperienciaService experienciaService;

	@GetMapping(value = "/buscar-por-id/{id}")
	public ResponseEntity<Experiencia> buscarPorId(@PathVariable Integer id) {
		Experiencia experienciaBusca = experienciaService.buscarPorId(id).get();
		return ResponseEntity.ok().body(experienciaBusca);
	}
	
	@PostMapping(value = "/inserir")
	public ResponseEntity<Experiencia> inserirExperiencia(@RequestBody Experiencia experiencia) {
		Experiencia experienciaCriada = experienciaService.inserirExperiencia(experiencia);
		return ResponseEntity.ok().body(experienciaCriada);
	}
	
	@PutMapping(value = "/atualizar/{id}")
	public ResponseEntity<Experiencia> atualizarExperiencia(@PathVariable Integer id, @RequestBody Experiencia experiencia) {
		Experiencia experienciaAtualizada = experienciaService.atualizarExperiencia(id, experiencia);
		return ResponseEntity.ok().body(experienciaAtualizada);
	}
	
	@DeleteMapping(value = "/deletar-por-id/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletarExperienciaPorId(@PathVariable Integer id) {
		experienciaService.deletarExperienciaPorId(id);
	}
}
