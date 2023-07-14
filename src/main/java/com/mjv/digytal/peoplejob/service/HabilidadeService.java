package com.mjv.digytal.peoplejob.service;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.mjv.digytal.peoplejob.model.Habilidade;
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
	
	public Optional<Habilidade> buscarPorId(Integer id) {
		return habilidadeRepository.findById(id);
	}
	
	public Habilidade inserirHabilidade(Habilidade habilidade) {
		return habilidadeRepository.save(habilidade);
	}
	
	public void deletarHabilidadePorId(Integer id) {
		habilidadeRepository.deleteById(id);
	}

	public Habilidade atualizarHabilidade(Integer id, Habilidade habilidade) {
		Habilidade habilidadeSalvar = validarSeExiste(id);
		BeanUtils.copyProperties(habilidade, habilidadeSalvar, "id");
		return habilidadeRepository.save(habilidadeSalvar);
	}
	
	private Habilidade validarSeExiste(Integer id) {
		Optional<Habilidade> habilidadeOpt = buscarPorId(id);
		if (!habilidadeOpt.isPresent()) {
			throw new EmptyResultDataAccessException(1);
		}
		return habilidadeOpt.get();
	}
	
	
}
