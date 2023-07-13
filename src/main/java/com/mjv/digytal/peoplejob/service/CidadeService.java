package com.mjv.digytal.peoplejob.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mjv.digytal.peoplejob.exceptions.DuplicatedObjectExcetion;
import com.mjv.digytal.peoplejob.model.Cidade;
import com.mjv.digytal.peoplejob.repository.CidadeRepository;

@Service
public class CidadeService {
	
	@Autowired
	private CidadeRepository cidadeRepository;

	public Cidade inserirCidade(Cidade cidade) {
		validarCidadeDuplicada(cidade);
		return cidadeRepository.save(cidade);
	}
	
	
	public void validarCidadeDuplicada(Cidade cidade) {
		
		Cidade cidadeEncontrada = cidadeRepository.findByNome(cidade.getNome());
		
		if (cidadeEncontrada != null && cidadeEncontrada.getId() != cidade.getId()) {
			throw new DuplicatedObjectExcetion(String.format("A cidade %s já está cadastrada",
					cidade.getNome().toUpperCase()));
		}
	}
	
}

