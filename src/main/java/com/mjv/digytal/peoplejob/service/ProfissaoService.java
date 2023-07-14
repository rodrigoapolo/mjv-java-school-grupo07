package com.mjv.digytal.peoplejob.service;

import java.util.List;

import com.mjv.digytal.peoplejob.dto.view.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mjv.digytal.peoplejob.model.Profissao;
import com.mjv.digytal.peoplejob.repository.CadastroRepository;
import com.mjv.digytal.peoplejob.repository.ProfissaoRepository;

@Service
public class ProfissaoService {

	@Autowired
	private ProfissaoRepository profissaoRepository;

	@Autowired
	private CadastroRepository cadastroRepository;

	public List<CadastroViewProfissao> imprimirCandidatosExcetoProfissao(String nome) {
		List<CadastroViewProfissao> candidatosNaoTrabalhando = cadastroRepository.bucarNaoProfissao(nome);
		return candidatosNaoTrabalhando;
	}

	public Profissao inserirProfissao(Profissao profissao) {
		return profissaoRepository.save(profissao);
	}

	public List<QuantidadeProfissaoPorCidadeView> agruparProfissaoCidade(String cidade){
		return profissaoRepository.agruparProfissaoCidade(cidade);
	}

	public List<ProfissaoCandidatoView> buscarCandidatosProfissao(){
		return profissaoRepository.buscarCandidatosProfissao();
	}

	public List<QuantidadeProfissionalView> contarProfissao(){
		return profissaoRepository.contarProfissao();
	}

	public List<CandidatoProfissaoView> nomeProfissaoCandidatos(String profissao){
		return profissaoRepository.nomeProfissaoCandidatos(profissao);
	}
}
