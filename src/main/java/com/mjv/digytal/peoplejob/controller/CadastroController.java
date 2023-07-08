package com.mjv.digytal.peoplejob.controller;

import com.mjv.digytal.peoplejob.model.Cadastro;
import com.mjv.digytal.peoplejob.service.CadastroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/cadastro")
public class CadastroController {

    @Autowired
    private CadastroService service;

    @GetMapping(value = "/busca-cpf/{cpf}")
    public ResponseEntity<Cadastro> buscaCPF(@PathVariable String cpf) {
        
    	Cadastro c = service.buscaCPF(cpf);
        
    	return ResponseEntity.ok().body(c);
        
    }
    
}
