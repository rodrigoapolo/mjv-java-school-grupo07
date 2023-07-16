package com.mjv.digytal.peoplejob.config;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

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

		List<Cadastro> list = popularTabelas();

		cadastroRepository.saveAll(list);

	}
	private List<Cadastro> popularTabelas() {
		List<Cadastro> cadastroList = new LinkedList<>();
		Cadastro c1 = new Cadastro();
		
		c1.setNome("Rodrigo");
		c1.setCpf("6546131");
		c1.setDataNascimento(LocalDate.of(2020, 1, 10));
		c1.setEmail("rodrigo@gmail.com");
		c1.setTelefone("11234568798");
		
		PretencaoSalarial pretencaoSalarial1 = new PretencaoSalarial();
		pretencaoSalarial1.setPretencaoMaxima(2000.0);
		pretencaoSalarial1.setPretencaoMinima(1950.0);
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
		
		Empresa empresa1 = new Empresa();
		empresa1.setNome("MJV");
		experiencia1.setEmpresa(empresa1);
		experiencia1.setProfissao(profissao1);
		c1.getExperiencias().add(experiencia1);

		Cadastro c2 = new Cadastro();

		c2.setNome("Pedro");
		c2.setCpf("984321");
		c2.setDataNascimento(LocalDate.of(1995, 1, 10));
		c2.setEmail("pedro@gmail.com");
		c2.setTelefone("1122168425");

		PretencaoSalarial pretencaoSalarial2 = new PretencaoSalarial();
		pretencaoSalarial2.setPretencaoMaxima(3500.0);
		pretencaoSalarial2.setPretencaoMinima(2000.0);
		c2.setPretencaoSalarial(pretencaoSalarial2);
		c2.setSexo(Sexo.MASCULINO);

		Celular celular2 = new Celular();
		celular2.setCelularNumero("1193158463");
		celular2.setCelularWhats(true);
		c2.setCelular(celular2);

		Endereco endereco2 = new Endereco();
		endereco2.setCep("0542233");
		endereco2.setLogradouro("Rua Silva");
		endereco2.setNumero("300");
		endereco2.setComplemento("casa A");
		endereco2.setBairro("São Pedro");

		Cidade cidade2 = new Cidade();
		cidade2.setNome("São Paulo");
		cidade2.setEstado("São Paulo");
		cidade2.setSigla("SP");
		endereco2.setCidade(cidade2);
		c2.setEndereco(endereco2);

		Profissao profissao2 = new Profissao();
		profissao2.setNome("java");
		c2.getProfissao().add(profissao2);

		Habilidade habilidade2 = new Habilidade();
		habilidade2.setNome("Java");
		c2.getHabilidades().add(habilidade2);

		Experiencia experiencia2 = new Experiencia();
		experiencia2.setSalario(2800.0);
		experiencia2.setEmpregoAtual(false);
		experiencia2.setDataContratacao(LocalDate.of(2020, 6, 25));
		experiencia2.setDataDesligamento(LocalDate.of(2020, 12, 30));
		experiencia2.setRegimeContratacao(RegimeContratacao.CLT);

		Empresa empresa2 = new Empresa();
		empresa2.setNome("MJV");
		experiencia2.setEmpresa(empresa2);
		experiencia2.setProfissao(profissao2);
		c2.getExperiencias().add(experiencia2);

		cadastroList.add(c1);
		cadastroList.add(c2);

		return cadastroList;

	}
}