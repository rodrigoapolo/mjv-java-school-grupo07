package com.mjv.digytal.peoplejob.service;

import com.mjv.digytal.peoplejob.model.Cadastro;
import com.mjv.digytal.peoplejob.repository.CadastroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CadastroService {
    @Autowired
    private CadastroRepository cadastroRepository;

    public Cadastro buscaCPF(String cpf){
       return cadastroRepository.getByCpf(cpf);
    }
}
