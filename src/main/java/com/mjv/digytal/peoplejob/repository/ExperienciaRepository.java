package com.mjv.digytal.peoplejob.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mjv.digytal.peoplejob.model.Experiencia;

@Repository
public interface ExperienciaRepository extends JpaRepository<Experiencia, Integer> {
	
}
