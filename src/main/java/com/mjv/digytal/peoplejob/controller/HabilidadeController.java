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

import com.mjv.digytal.peoplejob.model.Habilidade;
import com.mjv.digytal.peoplejob.service.HabilidadeService;

@RestController
@RequestMapping(value = "/habilidade")
public class HabilidadeController {

	@Autowired
	private HabilidadeService habilidadeService;
	
	@GetMapping(value = "/contar-por-habilidade/{habilidade}")
	private ResponseEntity<Integer> contarCandandidatosPorHabilidade(@PathVariable String habilidade) {
		int quantidade = habilidadeService.contarCandidatosPorHabilidades(habilidade);
		return ResponseEntity.ok().body(quantidade);
	}
	
	@GetMapping(value = "/buscar-por-id/{id}")
	public ResponseEntity<Habilidade> buscarPorId(@PathVariable Integer id) {
		Habilidade habilidade = habilidadeService.buscarPorId(id).get();
		return ResponseEntity.ok().body(habilidade);
	}
	
	@PutMapping("/atualizar/{id}")
	public ResponseEntity<Habilidade> atualizarHabilidade(@PathVariable Integer id, @RequestBody Habilidade habilidade) {
		Habilidade habilidadeAtualizada = habilidadeService.atualizarHabilidade(id, habilidade);
		return ResponseEntity.ok().body(habilidadeAtualizada);
	}
	
	@PostMapping("/inserir")
	private ResponseEntity<Habilidade> inserirHabilidade(@RequestBody Habilidade habilidade) {
		Habilidade habilidadeCriada = habilidadeService.inserirHabilidade(habilidade);
		return ResponseEntity.ok().body(habilidadeCriada);
	}
	
	@DeleteMapping(value = "/deletar-por-id/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletarHabilidadePorId(@PathVariable Integer id) {
		habilidadeService.deletarHabilidadePorId(id);
	}
	
}
