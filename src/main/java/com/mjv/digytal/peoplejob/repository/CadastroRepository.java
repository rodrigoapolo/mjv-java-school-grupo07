package com.mjv.digytal.peoplejob.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mjv.digytal.peoplejob.model.Cadastro;

@Repository
public interface CadastroRepository extends JpaRepository<Cadastro, Integer> {

	Cadastro getByCpf(String cpf);

}
