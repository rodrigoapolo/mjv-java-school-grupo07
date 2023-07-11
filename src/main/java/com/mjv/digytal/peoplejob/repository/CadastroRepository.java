package com.mjv.digytal.peoplejob.repository;

import java.time.LocalDate;
import java.util.List;

import com.mjv.digytal.peoplejob.dto.view.QuantidadeProfissao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mjv.digytal.peoplejob.model.Cadastro;

@Repository
public interface CadastroRepository extends JpaRepository<Cadastro, Integer> {

	Cadastro getByCpf(String cpf);

	@Query("select c from Cadastro c where c.dataNascimento between :dataInicio and :dataFinal")
	List<Cadastro> buscarCadastrosPorDataNascimento(LocalDate dataInicio, LocalDate dataFinal);

	@Query("select c from Cadastro c where c.endereco.cidade.nome = :cidade")
	List<Cadastro> buscarCadastrosPorCidade(String cidade);

	@Query("select count(c) as quantidade from Cadastro c INNER JOIN Profissao p on c.id = p.id where p.nome = :profissao")
	QuantidadeProfissao contarCadastrosPorProfissao(String profissao);

}
