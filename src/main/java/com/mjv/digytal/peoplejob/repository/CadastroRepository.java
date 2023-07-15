package com.mjv.digytal.peoplejob.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mjv.digytal.peoplejob.model.Cadastro;

@Repository
public interface CadastroRepository extends JpaRepository<Cadastro, Integer> {

	Cadastro getByCpf(String cpf);

	@Query("SELECT c FROM Cadastro c WHERE c.dataNascimento BETWEEN :dataInicio AND :dataFinal")
	List<Cadastro> buscarCadastrosPorDataNascimento(LocalDate dataInicio, LocalDate dataFinal);

	@Query("SELECT c FROM Cadastro c JOIN Cidade cid ON c.id = cid.id WHERE cid.nome = :cidade")
	List<Cadastro> buscarCadastrosPorCidade(String cidade);

	@Query("SELECT count(c) FROM Cadastro c JOIN c.profissao p WHERE p.nome = :profissao")
	Integer contarCadastrosPorProfissao(String profissao);

	@Query("SELECT c FROM Cadastro c JOIN c.experiencias e WHERE e.dataContratacao BETWEEN :dataInicial AND :dataFinal")
	List<Cadastro> listarCadastrosComExperiencasEntre(LocalDate dataInicial, LocalDate dataFinal);
	
	@Query("SELECT c FROM Cadastro c INNER JOIN c.experiencias exp INNER JOIN exp.empresa emp WHERE emp.nome = :nomeEmpresa")
	List<Cadastro> listarCadastrosTrabalharamNa(@Param("nomeEmpresa") String nomeEmpresa);
	
	@Query("SELECT c FROM Cadastro c INNER JOIN c.experiencias exp INNER JOIN exp.empresa emp WHERE emp.nome = :nomeEmpresa AND exp.empregoAtual = true")
	List<Cadastro> listarCadastrosQueTrabalhamNa(@Param("nomeEmpresa") String nomeEmpresa);
	
	
	
	// NOT WORKING //
	
	
	
	
	@Query("SELECT c FROM Cadastro c INNER JOIN c.experiencias e WHERE e.empregoAtual = true")
	List<Cadastro> listarCadastrosEmpregadosAtualmente();

}
