package com.mjv.digytal.peoplejob.repository;

import com.mjv.digytal.peoplejob.model.Experiencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExperienciaRepository extends JpaRepository<Experiencia, Integer> {
}
