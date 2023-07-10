package com.mjv.digytal.peoplejob.controller;

import com.mjv.digytal.peoplejob.dto.view.CadastroViewPretensao;
import com.mjv.digytal.peoplejob.dto.view.SalarioProfissaoView;
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

    @GetMapping(value = "/buscar-cpf/{cpf}")
    public ResponseEntity<Cadastro> buscarCPF(@PathVariable String cpf) {
    	Cadastro c = service.buscarCPF(cpf);
    	return ResponseEntity.ok().body(c);
    }

    @GetMapping(value = "/buscar-salarioMinimo-profissao/{profissao}")
    public ResponseEntity<SalarioProfissaoView> buscarSalarioMinimoProfissao(@PathVariable String profissao) {
        SalarioProfissaoView salarioMiminoProfissao = service.buscarSalarioMinimoProfissao(profissao);
        return ResponseEntity.ok().body(salarioMiminoProfissao);
    }

    @GetMapping(value = "/buscar-media-salarioMaximo-profissao/{profissao}")
    public ResponseEntity<SalarioProfissaoView> buscarMediaSalarioMinimoProfissao(@PathVariable String profissao) {
        SalarioProfissaoView mediaSalarioMaximoProfissao = service.buscarMediaSalarioMaximoProfissao(profissao);
        return ResponseEntity.ok().body(mediaSalarioMaximoProfissao);
    }
    
    @GetMapping(value = "/buscar-intervalos-salariominimo/{salariominimomenor}/{salariominimomaior}")
    public ResponseEntity<List<CadastroViewPretensao>> buscarIntervaloSalarioMinimo(
    		@PathVariable("salariominimomenor") Double salarioMinimoMenor,
    		@PathVariable("salariominimomaior") Double salarioMinimoMaior) {
		
    	List<CadastroViewPretensao> candidatosPorIntervaloSalMin = service
				.buscarIntervaloSalarioMinimo(salarioMinimoMenor, salarioMinimoMaior);
		
		return ResponseEntity.ok().body(candidatosPorIntervaloSalMin);
    }
}
