package com.mjv.digytal.peoplejob.repository;

import com.mjv.digytal.peoplejob.model.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Integer> {

}
