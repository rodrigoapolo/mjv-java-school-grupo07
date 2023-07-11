package com.mjv.digytal.peoplejob.repository;

import com.mjv.digytal.peoplejob.dto.view.CadastroView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mjv.digytal.peoplejob.model.Experiencia;

import java.util.List;

@Repository
public interface ExperienciaRepository extends JpaRepository<Experiencia, Integer> {
    @Query(value = "SELECT c.*\n" +
            "FROM TB_CADASTRO  c\n" +
            "INNER JOIN TB_EXPERIENCIA  e ON e.CADASTRO_ID  = c.ID\n" +
            "WHERE e.EMPREGO_ATUAL = :empregoAtual", nativeQuery = true)
    List<CadastroView> buscarCandidatosNaotrabalha(@Param("empregoAtual") boolean empregoAtual);
}
