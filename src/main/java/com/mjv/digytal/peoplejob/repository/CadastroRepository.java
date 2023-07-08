package com.mjv.digytal.peoplejob.repository;

import com.mjv.digytal.peoplejob.model.Cadastro;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

// 3 - Localizar os candidatos que mencionara o salário mínimo maior igual a 1.900 e menor que 3.000

@Repository
public interface CadastroRepository extends JpaRepository<Cadastro, Integer> {

    Cadastro getByCpf(String cpf);
    
}
