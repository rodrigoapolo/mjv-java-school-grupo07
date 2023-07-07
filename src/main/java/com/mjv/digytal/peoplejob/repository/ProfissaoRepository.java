package com.mjv.digytal.peoplejob.repository;

import com.mjv.digytal.peoplejob.model.Profissao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfissaoRepository extends JpaRepository<Profissao, Integer> {
}
