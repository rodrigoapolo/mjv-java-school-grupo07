package com.mjv.digytal.peoplejob.repository;


import com.mjv.digytal.peoplejob.dto.view.CadastroView;
import com.mjv.digytal.peoplejob.dto.view.SalarioProfissaoView;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mjv.digytal.peoplejob.model.Cadastro;

import com.mjv.digytal.peoplejob.dto.view.CadastroView;
import com.mjv.digytal.peoplejob.dto.view.CadastroViewPretensao;
import com.mjv.digytal.peoplejob.dto.view.CadastroViewProfissao;
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

    Cadastro getByCpf(String cpf);


	@Query("SELECT c FROM Cadastro c WHERE c.experiencia.empregoAtual = :empregoAtual")
	List<CadastroView> findNotWorkingCandidates(@Param("empregoAtual") boolean empregoAtual);

	@Query("SELECT c FROM Cadastro c JOIN c.profissao p WHERE p.nome <> :nome")
	List<CadastroViewProfissao> findNotProfissao(@Param("nome") String nome);

	@Query("SELECT c FROM Cadastro c WHERE c.pretencaoSalarial.pretencaoMinima >= :salarioMinimoMenor AND c.pretencaoSalarial.pretencaoMinima < :salarioMinimoMaior")
	List<CadastroViewPretensao> findIntervaloSalarioMinimo(@Param("salarioMinimoMenor") Double salarioMinimoMenor, @Param("salarioMinimoMaior") Double salarioMinimoMaior);

	@Query("SELECT MIN(c.pretencaoSalarial.pretencaoMinima) as salario, p.nome as profissao FROM Cadastro c INNER JOIN c.profissao p WHERE  p.nome = :profissao")
	SalarioProfissaoView buscarSalarioMinimoProfissao(@Param("profissao") String profissao);

	@Query("SELECT AVG(c.pretencaoSalarial.pretencaoMinima) as salario, p.nome as profissao FROM Cadastro c INNER JOIN c.profissao p WHERE  p.nome = :profissao")
	SalarioProfissaoView buscarMediaSalarioMaximoProfissao(@Param("profissao") String profissao);


}
