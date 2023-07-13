package com.mjv.digytal.peoplejob.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mjv.digytal.peoplejob.model.Habilidade;
import com.mjv.digytal.peoplejob.repository.CadastroRepository;
import com.mjv.digytal.peoplejob.repository.HabilidadeRepository;

@Service
public class HabilidadeService {

	@Autowired
	private CadastroRepository cadastroRepository;
	
	@Autowired
	private HabilidadeRepository habilidadeRepository;
	
	public int contarCandidatosPorHabilidades(String habilidade) {
		return cadastroRepository.contarCandidatosJava(habilidade);
	}
	
	public Habilidade inserirHabilidade(Habilidade habilidade) {
		return habilidadeRepository.save(habilidade);
	}
	
	
}
