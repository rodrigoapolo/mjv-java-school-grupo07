package com.mjv.digytal.peoplejob.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mjv.digytal.peoplejob.dto.CadastroDto;
import com.mjv.digytal.peoplejob.dto.view.CadastroViewHabilidade;
import com.mjv.digytal.peoplejob.dto.view.CadastroViewPretensao;
import com.mjv.digytal.peoplejob.dto.view.SalarioProfissaoView;
import com.mjv.digytal.peoplejob.model.Cadastro;
import com.mjv.digytal.peoplejob.model.Sexo;
import com.mjv.digytal.peoplejob.repository.CadastroRepository;

@Service
public class CadastroService {
    @Autowired
    private CadastroRepository cadastroRepository;

    public Cadastro buscarCPF(String cpf){
       return cadastroRepository.getByCpf(cpf);
    }

    public SalarioProfissaoView buscarSalarioMinimoProfissao(String profissao){
        return cadastroRepository.buscarSalarioMinimoProfissao(profissao);
    }

    public SalarioProfissaoView buscarMediaSalarioMaximoProfissao(String profissao){
        return cadastroRepository.buscarMediaSalarioMaximoProfissao(profissao);
    }

    public List<CadastroViewPretensao> buscarIntervaloSalarioMinimo(Double salarioMinimoMenor, Double salarioMinimoMaior) {
    	return cadastroRepository.bucarIntervaloSalarioMinimoMaximo(salarioMinimoMenor, salarioMinimoMaior);
    }
    
	public Cadastro cadastrar(Cadastro cadastro) {
		return cadastroRepository.save(cadastro);
	}

	public Cadastro buscaCPF(String cpf) {
		return cadastroRepository.getByCpf(cpf);
	}

/*	public List<Cadastro> buscarCadastrosEntreDatas(LocalDate dataInicio, LocalDate dataFim) {
		return cadastroRepository.buscarCadastrosPorDataNascimento(dataInicio, dataFim);
	}

	public List<Cadastro> buscarCadastrosPorCidadeEexperiencia(String cidade) {
		return cadastroRepository.buscarCadastrosPorCidade(cidade);
	}

	public QuantidadeProfissao buscarNumeroCadastrosPorProfissao(String profissao) {
		return cadastroRepository.contarCadastrosPorProfissao(profissao);
 	} */
	
	public List<CadastroViewHabilidade> buscarCandidatoPorHabilidade(String habilidade) {
		return cadastroRepository.buscarCandidatoPorHabilidade(habilidade);
	}
	
	public List<CadastroDto> buscarCandidatoPorSexoESigla(String sexo, String sigla) {
		return cadastroRepository.buscarCandidatoPorSexoESigla(Sexo.valueOf(sexo), sigla);
	}

}