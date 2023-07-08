package com.mjv.digytal.peoplejob.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mjv.digytal.peoplejob.dto.view.CadastroViewProfissao;
import com.mjv.digytal.peoplejob.model.Cadastro;
import com.mjv.digytal.peoplejob.repository.CadastroRepository;
import com.mjv.digytal.peoplejob.repository.ProfissaoRepository;

@Service
public class ProfissaoService {

	@Autowired
	private ProfissaoRepository profissaoRepository;

	@Autowired
	private CadastroRepository cadastroRepository;

	public List<CadastroViewProfissao> imprimirNaoAnalistaDeSistemas() {
		List<CadastroViewProfissao> candidatosNaoTrabalhando = cadastroRepository.findNotAnalistaDeSistemas();
		return candidatosNaoTrabalhando;
	}

}
