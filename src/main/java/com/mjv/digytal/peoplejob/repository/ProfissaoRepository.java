package com.mjv.digytal.peoplejob.repository;

import com.mjv.digytal.peoplejob.dto.view.ProfissaoCandidatoView;
import com.mjv.digytal.peoplejob.dto.view.QuantidadeProfissaoPorCidadeView;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.mjv.digytal.peoplejob.model.Profissao;

import java.util.List;


@Repository
public interface ProfissaoRepository extends JpaRepository<Profissao, Integer> {

	Profissao findByNome(String nome);

	@Query(value = "SELECT p.NOME AS profissao, COUNT(*) AS quantidade\n" +
			"FROM TB_PROFISSAO p\n" +
			"INNER JOIN PROFISSAO_CADASTRO pc ON p.ID = pc.PROFISSAO_ID\n" +
			"INNER JOIN TB_CADASTRO c ON c.ID = pc.CADASTRO_ID\n" +
			"INNER JOIN TB_CIDADE cida ON c.CIDADE_ID = cida.ID\n" +
			"WHERE LOWER(cida.NOME) = LOWER(:cidade)\n" +
			"GROUP BY p.NOME", nativeQuery = true)
	List<QuantidadeProfissaoPorCidadeView> agruparProfissaoCidade(@Param("cidade") String cidade);


}
