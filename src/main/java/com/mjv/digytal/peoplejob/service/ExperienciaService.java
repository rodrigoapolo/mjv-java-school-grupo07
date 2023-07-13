package com.mjv.digytal.peoplejob.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mjv.digytal.peoplejob.dto.view.CadastroView;
import com.mjv.digytal.peoplejob.model.Experiencia;
import com.mjv.digytal.peoplejob.repository.ExperienciaRepository;

@Service
public class ExperienciaService {
	
	@Autowired
	private ExperienciaRepository experienciaRepository;
	
	public List<CadastroView> imprimirNaoTrabalhando(boolean empregoAtual) {
		 List<CadastroView> candidatosNaoTrabalhando =
				 experienciaRepository.buscarCandidatosNaotrabalha(empregoAtual);
		 return candidatosNaoTrabalhando;
	}
	
	public Experiencia inserirExperiencia(Experiencia experiencia) {
		return experienciaRepository.save(experiencia);
	}
	
	public void deletarExperienciaPorId(Integer id) {
		experienciaRepository.deleteById(id);
	}
}
