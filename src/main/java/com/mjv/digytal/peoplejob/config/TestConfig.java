package com.mjv.digytal.peoplejob.config;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.mjv.digytal.peoplejob.model.Cadastro;
import com.mjv.digytal.peoplejob.model.Celular;
import com.mjv.digytal.peoplejob.model.Cidade;
import com.mjv.digytal.peoplejob.model.Empresa;
import com.mjv.digytal.peoplejob.model.Endereco;
import com.mjv.digytal.peoplejob.model.Experiencia;
import com.mjv.digytal.peoplejob.model.Habilidade;
import com.mjv.digytal.peoplejob.model.PretencaoSalarial;
import com.mjv.digytal.peoplejob.model.Profissao;
import com.mjv.digytal.peoplejob.model.RegimeContratacao;
import com.mjv.digytal.peoplejob.model.Sexo;
import com.mjv.digytal.peoplejob.repository.CadastroRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private CadastroRepository cadastroRepository;

	@Override
	public void run(String... args) throws Exception {

		Cadastro c1 = new Cadastro();
		c1.setNome("Rodrigo");
		c1.setCpf("6546131");
		c1.setDataNascimento(LocalDate.of(2020, 1, 10));
		c1.setEmail("rodrigo@gmail.com");
		c1.setTelefone("11234568798");
		PretencaoSalarial pretencaoSalarial1 = new PretencaoSalarial();
		pretencaoSalarial1.setPretencaoMaxima(1800.0);
		pretencaoSalarial1.setPretencaoMinima(1000.0);
		c1.setPretencaoSalarial(pretencaoSalarial1);
		c1.setSexo(Sexo.MASCULINO);
		Celular celular1 = new Celular();
		celular1.setCelularNumero("11564832486");
		celular1.setCelularWhats(true);
		c1.setCelular(celular1);
		Endereco endereco1 = new Endereco();
		endereco1.setCep("0542233");
		endereco1.setLogradouro("Rua Perdo");
		endereco1.setNumero("654");
		endereco1.setComplemento("casa");
		endereco1.setBairro("Jardim");
		Cidade cidade1 = new Cidade();
		cidade1.setNome("São Paulo");
		cidade1.setEstado("São Paulo");
		cidade1.setSigla("SP");
		endereco1.setCidade(cidade1);
		c1.setEndereco(endereco1);
		Profissao profissao1 = new Profissao();
		profissao1.setNome("Java");
		c1.getProfissao().add(profissao1);
		Habilidade habilidade1 = new Habilidade();
		habilidade1.setNome("Java");
		c1.getHabilidades().add(habilidade1);
		Experiencia experiencia1 = new Experiencia();
		experiencia1.setSalario(3500.0);
		experiencia1.setEmpregoAtual(false);
		experiencia1.setDataContratacao(LocalDate.of(2020, 6, 25));
		experiencia1.setDataDesligamento(LocalDate.of(2020, 12, 30));
		experiencia1.setRegimeContratacao(RegimeContratacao.CLT);
//		c1.getExperiencias().add(experiencia1);
		Empresa empresa1 = new Empresa();
		empresa1.setNome("MJV");
		experiencia1.setEmpresa(empresa1);
		experiencia1.setProfissao(profissao1);

		Cadastro c2 = new Cadastro();
		Cadastro c3 = new Cadastro();

		cadastroRepository.save(c1);

	}
}
