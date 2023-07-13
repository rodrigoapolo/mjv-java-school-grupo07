package com.mjv.digytal.peoplejob.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mjv.digytal.peoplejob.model.Empresa;
import com.mjv.digytal.peoplejob.repository.EmpresaRepository;

@Service
public class EmpresaService {

	@Autowired
	private EmpresaRepository empresaRepository;
	
	public Empresa inserirEmpresa(Empresa empresa) {
		return empresaRepository.save(empresa);
	}

}
