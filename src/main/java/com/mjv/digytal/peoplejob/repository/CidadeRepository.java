package com.mjv.digytal.peoplejob.repository;

import com.mjv.digytal.peoplejob.model.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Integer> {

	Cidade findByNome(String nome);
	
}
