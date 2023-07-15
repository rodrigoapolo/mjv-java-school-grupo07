package com.mjv.digytal.peoplejob.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mjv.digytal.peoplejob.model.Cadastro;
import com.mjv.digytal.peoplejob.repository.CadastroRepository;

@Service
public class CadastroService {
	@Autowired
	private CadastroRepository cadastroRepository;

	public Cadastro cadastrar(Cadastro cadastro) {
		return cadastroRepository.save(cadastro);
	}

	public Cadastro buscaCPF(String cpf) {
		return cadastroRepository.getByCpf(cpf);
	}

	public List<Cadastro> buscarCadastrosEntreDatas(LocalDate dataInicio, LocalDate dataFim) {
		return cadastroRepository.buscarCadastrosPorDataNascimento(dataInicio, dataFim);
	}

	public List<Cadastro> buscarCadastrosPorCidadeEexperiencia(String cidade) {
		List<Cadastro> cadastrosDeIniciantes = new ArrayList<>();
		List<Cadastro> cadastros = cadastroRepository.buscarCadastrosPorCidade(cidade);
		cadastros.stream().filter(cadastro -> cadastro.getExperiencias().size() == 0)
				.forEach(cadastro -> cadastrosDeIniciantes.add(cadastro));
		return cadastrosDeIniciantes;
	}

	public Integer buscarNumeroCadastrosPorProfissao(String profissao) {
		Integer cadastros = cadastroRepository.contarCadastrosPorProfissao(profissao);
		return cadastros;
	}

	public List<Cadastro> listarCadastrosComExperiencasEntre(LocalDate dataInicial, LocalDate dataFinal) {
		return cadastroRepository.listarCadastrosComExperiencasEntre(dataInicial, dataFinal);
	}

	public List<Cadastro> listarCadastrosTrabalharamNa(String empresa) {
		return cadastroRepository.listarCadastrosTrabalharamNa(empresa);
	}

	public List<Cadastro> listarCadastrosQueTrabalhamNa(String empresa) {
		return cadastroRepository.listarCadastrosQueTrabalhamNa(empresa);
	}

	public List<Cadastro> listarCadastrosEmpregadosAtualmente() {
		return cadastroRepository.listarCadastrosEmpregadosAtualmente();
	}

}
