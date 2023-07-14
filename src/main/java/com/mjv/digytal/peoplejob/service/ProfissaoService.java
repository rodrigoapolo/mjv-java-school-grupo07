package com.mjv.digytal.peoplejob.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import com.mjv.digytal.peoplejob.dto.view.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
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
		List<CadastroViewProfissao> candidatosNaoTrabalhando = cadastroRepository.buscarNaoProfissao(nome);
		return candidatosNaoTrabalhando;
	}

	public Profissao inserirProfissao(Profissao profissao) {
		return profissaoRepository.save(profissao);
	}
	
	public Optional<Profissao> buscarPorId(Integer id) {
		return profissaoRepository.findById(id);
	}
	
	public void deletarProfissaoPorId(Integer id) {
		profissaoRepository.deleteById(id);
	}
	
	public Profissao atualizarProfissao(Integer id, Profissao profissao) {
		Profissao profissaoSalvar = validarSeExiste(id);
		BeanUtils.copyProperties(profissao, profissaoSalvar, "id");
		return profissaoRepository.save(profissaoSalvar);
	}
	
	private Profissao validarSeExiste(Integer id) {
		Optional<Profissao> profissaoOpt = buscarPorId(id);
		if (!profissaoOpt.isPresent()) {
			throw new EmptyResultDataAccessException(1);
		}
		return profissaoOpt.get();
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
