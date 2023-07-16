package com.mjv.digytal.peoplejob.service;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.mjv.digytal.peoplejob.model.Cidade;
import com.mjv.digytal.peoplejob.repository.CidadeRepository;

@Service
public class CidadeService {
	
	@Autowired
	private CidadeRepository cidadeRepository;

	public Cidade inserirCidade(Cidade cidade) {
		return cidadeRepository.save(cidade);
	}

	public Optional<Cidade> buscarPorId(Integer id) {
		return cidadeRepository.findById(id);
	}

	public void deletarCidadePorId(Integer id) {
		cidadeRepository.deleteById(id);
	}

	public Cidade atualizarCidade(Integer id, Cidade cidade) {
		Cidade cidadeSalvar = validarSeExiste(id);
		BeanUtils.copyProperties(cidade, cidadeSalvar, "id");
		return cidadeRepository.save(cidadeSalvar);
	}
	
	private Cidade validarSeExiste(Integer id) {
		Optional<Cidade> cidadeOpt = buscarPorId(id);
		if (!cidadeOpt.isPresent()) {
			throw new EmptyResultDataAccessException(1);
		}
		return cidadeOpt.get();
	}
}
