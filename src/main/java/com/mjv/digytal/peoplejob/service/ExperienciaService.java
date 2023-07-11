package com.mjv.digytal.peoplejob.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mjv.digytal.peoplejob.dto.view.CadastroView;
import com.mjv.digytal.peoplejob.repository.CadastroRepository;

@Service
public class ExperienciaService {
	
	@Autowired
	private CadastroRepository experienciaRepository;
	
	public List<CadastroView> imprimirNaoTrabalhando(boolean empregoAtual) {
		 List<CadastroView> candidatosNaoTrabalhando =
				 experienciaRepository.findNotWorkingCandidates(empregoAtual);
		 return candidatosNaoTrabalhando;
	}
	
}
