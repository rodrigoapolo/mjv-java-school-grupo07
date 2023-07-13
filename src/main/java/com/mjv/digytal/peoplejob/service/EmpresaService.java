package com.mjv.digytal.peoplejob.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mjv.digytal.peoplejob.exceptions.DuplicatedObjectExcetion;
import com.mjv.digytal.peoplejob.model.Empresa;
import com.mjv.digytal.peoplejob.repository.EmpresaRepository;

@Service
public class EmpresaService {

	@Autowired
	private EmpresaRepository empresaRepository;
	
	public Empresa inserirEmpresa(Empresa empresa) {
		validarEmpresaDuplicada(empresa);
		return empresaRepository.save(empresa);
	}
	
	
	public void validarEmpresaDuplicada(Empresa empresa) {
		
		Empresa empresaEncontrada = empresaRepository.findByNome(empresa.getNome());
		
		if (empresaEncontrada != null && empresaEncontrada.getId() != empresa.getId()) {
			throw new DuplicatedObjectExcetion(String.format("A empresa %s já está cadastrada",
					empresa.getNome().toUpperCase()));
		}
	}
}
