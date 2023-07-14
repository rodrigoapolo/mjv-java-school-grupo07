package com.mjv.digytal.peoplejob.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mjv.digytal.peoplejob.dto.view.CadastroView;
import com.mjv.digytal.peoplejob.dto.view.CadastroViewHabilidade;
import com.mjv.digytal.peoplejob.dto.view.CadastroViewPretensao;
import com.mjv.digytal.peoplejob.dto.view.CadastroViewProfissao;
import com.mjv.digytal.peoplejob.dto.view.CadastroViewSexoEndereco;
import com.mjv.digytal.peoplejob.dto.view.QuantidadeProfissao;
import com.mjv.digytal.peoplejob.dto.view.SalarioProfissaoView;
import com.mjv.digytal.peoplejob.model.Cadastro;
import com.mjv.digytal.peoplejob.model.Sexo;


@Repository
public interface CadastroRepository extends JpaRepository<Cadastro, Integer> {

    Cadastro getByCpf(String cpf);

	@Query("select c from Cadastro c where c.dataNascimento between :dataInicio and :dataFinal")
	List<CadastroView> buscarCadastrosPorDataNascimento(LocalDate dataInicio, LocalDate dataFinal);

	@Query("select c from Cadastro c INNER JOIN c.experiencias e where c.endereco.cidade.nome = :cidade AND e.empregoAtual = false ")
	List<CadastroView> buscarCadastrosPorCidade(String cidade);

	@Query("select count(c) as quantidade from Cadastro c INNER JOIN Profissao p on c.id = p.id where p.nome = :profissao")
	QuantidadeProfissao contarCadastrosPorProfissao(String profissao);
	
	@Query("SELECT c FROM Cadastro c JOIN c.profissao p WHERE p.nome <> :nome")
	List<CadastroViewProfissao> buscarNaoProfissao(@Param("nome") String nome);
	
	@Query("SELECT c FROM Cadastro c WHERE c.pretencaoSalarial.pretencaoMinima >= :salarioMinimoMenor AND c.pretencaoSalarial.pretencaoMinima < :salarioMinimoMaior")
	List<CadastroViewPretensao> bucarIntervaloSalarioMinimoMaximo(@Param("salarioMinimoMenor") Double salarioMinimoMenor, @Param("salarioMinimoMaior") Double salarioMinimoMaior);

	@Query("SELECT MIN(c.pretencaoSalarial.pretencaoMinima) as salario, p.nome as profissao FROM Cadastro c INNER JOIN c.profissao p WHERE  p.nome = :profissao")
	SalarioProfissaoView buscarSalarioMinimoProfissao(@Param("profissao") String profissao);

	@Query("SELECT AVG(c.pretencaoSalarial.pretencaoMinima) as salario, p.nome as profissao FROM Cadastro c INNER JOIN c.profissao p WHERE  p.nome = :profissao")
	SalarioProfissaoView buscarMediaSalarioMaximoProfissao(@Param("profissao") String profissao);

	@Query("SELECT COUNT(c) FROM Cadastro c JOIN c.habilidades h WHERE h.nome = :habilidade")
    int contarCandidatosJava(@Param("habilidade") String habilidade);

	@Query("SELECT c FROM Cadastro c JOIN c.habilidades h WHERE h.nome = :habilidade")
	List<CadastroViewHabilidade> buscarCandidatoPorHabilidade(@Param("habilidade") String habilidade);

	@Query("SELECT c FROM Cadastro c JOIN c.endereco.cidade cidade WHERE c.sexo = :sexo AND cidade.sigla = :sigla")
	List<CadastroViewSexoEndereco> buscarCandidatoPorSexoESigla(@Param("sexo") Sexo sexo, @Param("sigla") String sigla);

}
