package com.mjv.digytal.peoplejob.repository;

import com.mjv.digytal.peoplejob.dto.view.CadastroView;
import com.mjv.digytal.peoplejob.dto.view.SalarioMiminoView;
import com.mjv.digytal.peoplejob.model.Cadastro;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

// 3 - Localizar os candidatos que mencionara o salário mínimo maior igual a 1.900 e menor que 3.000

@Repository
public interface CadastroRepository extends JpaRepository<Cadastro, Integer> {

    Cadastro getByCpf(String cpf);
    
	
	@Query("SELECT c FROM Cadastro c WHERE c.experiencia.empregoAtual = :empregoAtual ORDER BY c.id")
	List<CadastroView> findNotWorkingCandidates(@Param("empregoAtual") boolean empregoAtual);

	@Query("SELECT MIN(c.pretencaoSalarial.pretencaoMinima) as salarialMinimo, p.nome as profissao FROM Cadastro c INNER JOIN c.profissao p WHERE  p.nome = :profissao")
	SalarioMiminoView buscarSalarioMinimoProfissao(@Param("profissao") String profissao);

}
