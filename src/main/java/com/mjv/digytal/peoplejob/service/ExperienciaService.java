package com.mjv.digytal.peoplejob.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.mjv.digytal.peoplejob.dto.CadastroView;
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
	
	public Optional<Experiencia> buscarPorId(Integer id) {
		return experienciaRepository.findById(id);
	}
	
	public Experiencia inserirExperiencia(Experiencia experiencia) {
		return experienciaRepository.save(experiencia);
	}
	
	public void deletarExperienciaPorId(Integer id) {
		experienciaRepository.deleteById(id);
	}
	
	public Experiencia atualizarExperiencia(Integer id, Experiencia experiencia) {
		Experiencia experienciaSalvar = validarSeExiste(id);
		BeanUtils.copyProperties(experiencia, experienciaSalvar, "id");
		return experienciaRepository.save(experienciaSalvar);
	}
	
	private Experiencia validarSeExiste(Integer id) {
		Optional<Experiencia> experienciaOpt = buscarPorId(id);
		if (!experienciaOpt.isPresent()) {
			throw new EmptyResultDataAccessException(1);
		}
		return experienciaOpt.get();
	}
	
}
