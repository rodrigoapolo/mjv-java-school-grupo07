package com.mjv.digytal.peoplejob.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.mjv.digytal.peoplejob.dto.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.mjv.digytal.peoplejob.model.Cadastro;
import com.mjv.digytal.peoplejob.model.Sexo;
import com.mjv.digytal.peoplejob.repository.CadastroRepository;

@Service
public class CadastroService {

	@Autowired
	private CadastroRepository cadastroRepository;

	public List<CadastroView> imprimirNaoTrabalhando(boolean empregoAtual) {
		 List<CadastroView> candidatosNaoTrabalhando =
				 cadastroRepository.buscarCandidatosNaotrabalha(empregoAtual);
		 return candidatosNaoTrabalhando;
	}
	
	public Optional<Cadastro> buscarPorId(Integer id) {
		return cadastroRepository.findById(id);
	}

	public Cadastro buscarCPF(String cpf) {
		return cadastroRepository.getByCpf(cpf);
	}

	public QuantidadeHabilidadeView contarCandidatosPorHabilidades(String habilidade) {
		return cadastroRepository.contarCandidatosHabilidade(habilidade);
	}

	public List<CadastroPretensaoView> buscarIntervaloSalarioMinimo(Double salarioMinimoMenor,
                                                                    Double salarioMinimoMaior) {
		return cadastroRepository.bucarIntervaloSalarioMinimoMaximo(salarioMinimoMenor, salarioMinimoMaior);
	}

	public List<CadastroView> buscarCadastrosEntreDatas(LocalDate dataInicio, LocalDate dataFim) {
		return cadastroRepository.buscarCadastrosPorDataNascimento(dataInicio, dataFim);
	}

	public List<CadastroView> buscarCadastrosPorCidadeEexperiencia(String cidade) {
		return cadastroRepository.buscarCadastrosPorCidade(cidade);
	}

	public QuantidadeProfissaoView buscarNumeroCadastrosPorProfissao(String profissao) {
		return cadastroRepository.contarCadastrosPorProfissao(profissao);
	}

	public List<CadastroHabilidadeView> buscarCandidatoPorHabilidade(String habilidade) {
		return cadastroRepository.buscarCandidatoPorHabilidade(habilidade);
	}

	public List<CadastroSexoEnderecoView> buscarCandidatoPorSexoESigla(String sexo, String sigla) {
		return cadastroRepository.buscarCandidatoPorSexoESigla(Sexo.valueOf(sexo), sigla);
	}

	public List<CadastroProfissaoView> buscarCandidatosExcetoProfissao(String nome) {
		List<CadastroProfissaoView> candidatosNaoTrabalhando = cadastroRepository.buscarNaoProfissao(nome);
		return candidatosNaoTrabalhando;
	}

	public Cadastro inserirCadastro(Cadastro cadastro) {
		return cadastroRepository.save(cadastro);
	}

	public void deletarCadastroPorId(Integer id) {
		cadastroRepository.deleteById(id);
	}

	public Cadastro atualizarCadastro(Integer id, Cadastro cadastro) {
		Cadastro cadastroSalvar = validarSeExiste(id);
		BeanUtils.copyProperties(cadastro, cadastroSalvar, "id");
		return cadastroRepository.save(cadastroSalvar);
	}
	
	private Cadastro validarSeExiste(Integer id) {
		Optional<Cadastro> cadastroOpt = buscarPorId(id);
		if (!cadastroOpt.isPresent()) {
			throw new EmptyResultDataAccessException(1);
		}
		return cadastroOpt.get();
	}
	
}