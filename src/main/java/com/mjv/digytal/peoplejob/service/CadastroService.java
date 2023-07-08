package com.mjv.digytal.peoplejob.service;

import com.mjv.digytal.peoplejob.dto.view.SalarioMiminoView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mjv.digytal.peoplejob.model.Cadastro;
import com.mjv.digytal.peoplejob.repository.CadastroRepository;

import java.util.List;

@Service
public class CadastroService {
	
    @Autowired
    private CadastroRepository cadastroRepository;

    public Cadastro buscarCPF(String cpf){
       return cadastroRepository.getByCpf(cpf);
    }

    public SalarioMiminoView buscarSalarioMinimoProfissao(String profissao){
        return cadastroRepository.buscarSalarioMinimoProfissao(profissao);
    }
    
}
