package com.mjv.digytal.peoplejob.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.mjv.digytal.peoplejob.dto.CadastroHabilidadeView;
import com.mjv.digytal.peoplejob.dto.CadastroPretensaoView;
import com.mjv.digytal.peoplejob.dto.CadastroProfissaoView;
import com.mjv.digytal.peoplejob.dto.CadastroSexoEnderecoView;
import com.mjv.digytal.peoplejob.dto.CadastroView;
import com.mjv.digytal.peoplejob.dto.QuantidadeHabilidadeView;
import com.mjv.digytal.peoplejob.dto.QuantidadeProfissaoView;
import com.mjv.digytal.peoplejob.model.Cadastro;
import com.mjv.digytal.peoplejob.model.Experiencia;
import com.mjv.digytal.peoplejob.model.Sexo;
import com.mjv.digytal.peoplejob.repository.CadastroRepository;
import com.mjv.digytal.peoplejob.repository.EmpresaRepository;
import com.mjv.digytal.peoplejob.repository.ExperienciaRepository;
import com.mjv.digytal.peoplejob.repository.ProfissaoRepository;

@Service
public class CadastroService {

	@Autowired
	private CadastroRepository cadastroRepository;
	
	@Autowired
	private ExperienciaRepository experienciaRepository;
	
	@Autowired
	private EmpresaRepository empresaRepository;
	
	@Autowired
	private ProfissaoRepository profissaoRepository;

	public List<CadastroView> imprimirNaoTrabalhando(boolean empregoAtual) {
		 List<CadastroView> candidatosNaoTrabalhando =
				 cadastroRepository.buscarCandidatosNaotrabalha(empregoAtual);
		 return candidatosNaoTrabalhando;
	}
	
	public Cadastro adicionarExperienciaAoCadastro(Integer cadastroId, Experiencia experiencia, 
													Integer empresaId, Integer profissaoId) {
		
		Experiencia experienciaSalva = experienciaRepository.save(experiencia);
		experienciaSalva.setEmpresa(empresaRepository.findById(empresaId).get());
		experienciaSalva.setProfissao(profissaoRepository.findById(profissaoId).get());
		
		Cadastro cadastro = cadastroRepository.findById(cadastroId).get();
		
		if(cadastro != null) {
			cadastro.getExperiencias().add(experienciaSalva);
			return cadastroRepository.save(cadastro);
		}
		return null;
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