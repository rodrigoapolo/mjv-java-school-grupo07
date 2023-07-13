package com.mjv.digytal.peoplejob.service;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	

}

