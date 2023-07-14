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
import com.mjv.digytal.peoplejob.model.Habilidade;
import com.mjv.digytal.peoplejob.service.HabilidadeService;

@RestController
@RequestMapping(value = "/habilidade")
public class HabilidadeController {

	@Autowired
	private HabilidadeService habilidadeService;
	
	@GetMapping(value = "/contar-candidatos-por-habilidade/{habilidade}")
	private ResponseEntity<Integer> contarCandandidatosPorHabilidade(@PathVariable String habilidade) {
		int quantidade = habilidadeService.contarCandidatosPorHabilidades(habilidade);
		return ResponseEntity.ok().body(quantidade);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Experiencia> atualizarExperiencia(@PathVariable Integer id, @RequestBody Experiencia experiencia) {
		Experiencia experienciaAtualizada = experienciaService.atualizarExperiencia(id, experiencia);
		return ResponseEntity.ok().body(experienciaAtualizada);
	}
	
	@PostMapping
	private ResponseEntity<Habilidade> inserirHabilidade(@RequestBody Habilidade habilidade) {
		Habilidade habilidadeCriada = habilidadeService.inserirHabilidade(habilidade);
		return ResponseEntity.ok().body(habilidadeCriada);
	}
	
	@DeleteMapping(value = "deletar-habilidade-por-id/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletarHabilidadePorId(@PathVariable Integer id) {
		habilidadeService.deletarHabilidadePorId(id);
	}
	
}
