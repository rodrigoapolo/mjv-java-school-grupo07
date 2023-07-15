package com.mjv.digytal.peoplejob.controller;


import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.mjv.digytal.peoplejob.dto.CadastroView;
import com.mjv.digytal.peoplejob.dto.CadastroHabilidadeView;
import com.mjv.digytal.peoplejob.dto.CadastroPretensaoView;
import com.mjv.digytal.peoplejob.dto.CadastroProfissaoView;
import com.mjv.digytal.peoplejob.dto.CadastroSexoEnderecoView;
import com.mjv.digytal.peoplejob.dto.QuantidadeProfissaoView;
import com.mjv.digytal.peoplejob.dto.SalarioProfissaoView;
import com.mjv.digytal.peoplejob.model.Cadastro;
import com.mjv.digytal.peoplejob.service.CadastroService;

@RestController
@RequestMapping(value = "/cadastro")
public class CadastroController {

    @Autowired
    private CadastroService service;

	@GetMapping(value = "/buscar-cpf/{cpf}")
	public ResponseEntity<Cadastro> buscarCPF(@PathVariable String cpf) {
		Cadastro cadastroBusca = service.buscarCPF(cpf);
		return ResponseEntity.ok().body(cadastroBusca);
	}
	
	@GetMapping(value = "/buscar-por-id/{id}")
	public ResponseEntity<Cadastro> buscarPorId(@PathVariable Integer id) {
		Cadastro cadastroBusca = service.buscarPorId(id).get();
		return ResponseEntity.ok().body(cadastroBusca);
	}
	
	@GetMapping(value = "/buscar-por-data-de-nascimento/{dataInicio}/{dataFim}")
	public ResponseEntity<List<CadastroView>> buscarCadastrosEntreDatas(
			@PathVariable("dataInicio") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate dataInicio,
			@PathVariable("dataFim") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate dataFim) {
		return ResponseEntity.ok(service.buscarCadastrosEntreDatas(dataInicio, dataFim));
	}

	@GetMapping(value = "/buscar-cadastros-cidade-naoexperiencia/{cidade}")
	public ResponseEntity<List<CadastroView>> buscarCadastrosPorCidadeEexperiencia(@PathVariable String cidade) {
		return ResponseEntity.ok(service.buscarCadastrosPorCidadeEexperiencia(cidade));
	}

	@GetMapping(value = "/buscar-quantidade-por-profissao")
	public ResponseEntity<QuantidadeProfissaoView> buscarNumeroCadastrosPorProfissao(String profissao) {
		return ResponseEntity.ok(service.buscarNumeroCadastrosPorProfissao(profissao));
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
    public ResponseEntity<List<CadastroPretensaoView>> buscarIntervaloSalarioMinimo(
    		@PathVariable("salariominimomenor") Double salarioMinimoMenor,
    		@PathVariable("salariominimomaior") Double salarioMinimoMaior) {
    	List<CadastroPretensaoView> candidatosPorIntervaloSalMin = service
				.buscarIntervaloSalarioMinimo(salarioMinimoMenor, salarioMinimoMaior);
		return ResponseEntity.ok().body(candidatosPorIntervaloSalMin);
    }
    
	@GetMapping(value = "/contar-por-habilidade/{habilidade}")
	private ResponseEntity<Integer> contarCandandidatosPorHabilidade(@PathVariable String habilidade) {
		int quantidade = service.contarCandidatosPorHabilidades(habilidade);
		return ResponseEntity.ok().body(quantidade);
	}

	@GetMapping(value = "/buscar-exceto-profissao")
	public ResponseEntity<List<CadastroProfissaoView>> imprimirCandidatosExcetoProfissao(String nome) {
		List<CadastroProfissaoView> candidatosNaoAnalistas = service.buscarCandidatosExcetoProfissao(nome);
		return ResponseEntity.ok().body(candidatosNaoAnalistas);
	}

    @GetMapping(value = "/buscar-por-habilidade/{habilidade}")
    public ResponseEntity<List<CadastroHabilidadeView>> buscarCandidatoPorHabilidade(
    		@PathVariable("habilidade") String habilidade) {
    	List<CadastroHabilidadeView> cadastrosRelacionados = service
    			.buscarCandidatoPorHabilidade(habilidade);
    	return ResponseEntity.ok().body(cadastrosRelacionados);
    }

    @GetMapping(value = "/buscar-por-sexo-e-sigla/{sexo}/{sigla}")
    public ResponseEntity<List<CadastroSexoEnderecoView>> buscarCandidatoPorSexoESigla(
    		@PathVariable("sexo") String sexo, @PathVariable("sigla") String sigla) {
    	List<CadastroSexoEnderecoView> cadastrosRelacionados = service
    			.buscarCandidatoPorSexoESigla(sexo, sigla);
    	return ResponseEntity.ok().body(cadastrosRelacionados);
    }
    
	@PostMapping(value = "/inserir")
    public ResponseEntity<Cadastro> inserirCadastro(@RequestBody Cadastro cadastro) {
    	Cadastro cadastroCriado = service.inserirCadastro(cadastro);
    	return ResponseEntity.ok().body(cadastroCriado);
    }
    
    @PutMapping(value = "/atualizar/{id}")
    public ResponseEntity<Cadastro> atualizarCadastro(@PathVariable Integer id, @RequestBody Cadastro cadastro) {
    	Cadastro cadastroAtualizado = service.atualizarCadastro(id, cadastro);
    	return ResponseEntity.ok().body(cadastroAtualizado);
    }
    
    @DeleteMapping(value = "/deletar-por-id/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarCadastro(@PathVariable Integer id) {
    	service.deletarCadastroPorId(id);
    }

}
