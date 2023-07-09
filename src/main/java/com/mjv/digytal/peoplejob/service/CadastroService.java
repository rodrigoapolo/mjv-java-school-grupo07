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
		return cadastroRepository.findCadastroByDataNascimento(dataInicio, dataFim);
	}

	public List<Cadastro> buscarCandidatosPorCidadeEexperiencia() {
		List<Cadastro> cadastrosDeIniciantes = new ArrayList<>();
		List<Cadastro> cadastros = cadastroRepository.findCadastroByCidade();
		cadastros.stream().filter(cadastro -> cadastro.getExperiencias().size() == 0)
				.forEach(cadastro -> cadastrosDeIniciantes.add(cadastro));
		return cadastrosDeIniciantes;
	}

	public Integer buscarCandidatosAnalistasDeSistemas() {
		List<Cadastro> cadastros = cadastroRepository.findCadastroByProfissao();
		return cadastros.size();
	}

}
