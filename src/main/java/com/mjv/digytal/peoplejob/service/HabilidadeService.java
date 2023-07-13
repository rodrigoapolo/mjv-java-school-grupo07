package com.mjv.digytal.peoplejob.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mjv.digytal.peoplejob.repository.CadastroRepository;

@Service
public class HabilidadeService {

	@Autowired
	private CadastroRepository cadastroRepository;
	
	public int contarCandidatosPorHabilidades(String habilidade) {
		return cadastroRepository.contarCandidatosJava(habilidade);
	}
	
}
