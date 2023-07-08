package com.mjv.digytal.peoplejob.repository;

import com.mjv.digytal.peoplejob.model.Habilidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HabilidadeRepository extends JpaRepository<Habilidade, Integer> {
}
