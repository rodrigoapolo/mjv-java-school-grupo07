package com.mjv.digytal.peoplejob.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mjv.digytal.peoplejob.model.Cadastro;
import com.mjv.digytal.peoplejob.model.Profissao;
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

	public List<Cadastro> buscar_candidatos_entre_anos_oitenta_a_vinte_e_tres() {
		List<Cadastro> novosCadastros = new ArrayList<>();
		List<Cadastro> cadastros = cadastroRepository.findAll();

		cadastros.stream()
				.filter(cadastro -> cadastro.getDataNascimento().getYear() >= 1980
						&& cadastro.getDataNascimento().getYear() <= 2023)
				.forEach(cadastro -> novosCadastros.add(cadastro));

		return novosCadastros;
	}

	public List<Cadastro> buscar_candidato_por_cidade_e_experiencia() {
		List<Cadastro> novosCadastros = new ArrayList<>();
		List<Cadastro> cadastros = cadastroRepository.findAll();
		cadastros.stream().filter(cadastro -> cadastro.getEndereco().getCidade().getNome().equalsIgnoreCase("São Paulo")
				&& cadastro.getExperiencias().isEmpty()).forEach(cadastro -> novosCadastros.add(cadastro));
		return novosCadastros;
	}

	public Integer buscar_analista_de_sistemas() {
		Integer contar = 0;
		List<Profissao> profissionais = new ArrayList<>();
		List<Cadastro> cadastros = cadastroRepository.findAll();
		cadastros.forEach(cadastro -> {
			cadastro.getProfissao().stream()
					.filter(profissao -> profissao.getNome().equalsIgnoreCase("Analista de Sistemas"))
					.forEach(profissao -> profissionais.add(profissao));
		});
		contar = profissionais.size();
		return contar;
	}

}
