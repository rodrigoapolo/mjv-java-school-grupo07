package com.mjv.digytal.peoplejob.service;


import com.mjv.digytal.peoplejob.dto.view.SalarioProfissaoView;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mjv.digytal.peoplejob.dto.view.CadastroViewPretensao;
import com.mjv.digytal.peoplejob.model.Cadastro;
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
    	return cadastroRepository.findIntervaloSalarioMinimo(salarioMinimoMenor, salarioMinimoMaior);
    }
}
