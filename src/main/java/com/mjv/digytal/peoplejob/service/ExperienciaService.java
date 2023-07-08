package com.mjv.digytal.peoplejob.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mjv.digytal.peoplejob.model.Experiencia;
import com.mjv.digytal.peoplejob.repository.ExperienciaRepository;

@Service
public class ExperienciaService {
	
	@Autowired
	private ExperienciaRepository experienciaRepository;
	
	public List<Experiencia> imprimirNaoTrabalhando(boolean empregoAtual) {
		
		 List<Experiencia> candidatosNaoTrabalhando =
				 experienciaRepository.findNotWorkingCandidates(empregoAtual);
		 return candidatosNaoTrabalhando;
		 
	}
	
}
