package com.mjv.digytal.peoplejob.repository;

import com.mjv.digytal.peoplejob.model.Experiencia;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ExperienciaRepository extends JpaRepository<Experiencia, Integer> {
	
	@Query("SELECT e FROM Experiencia e WHERE e.empregoAtual = :empregoAtual")
	List<Experiencia> findNotWorkingCandidates(@Param("empregoAtual") boolean empregoAtual);
	
}
