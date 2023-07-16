package com.mjv.digytal.peoplejob.service;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
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
	
	public Optional<Empresa> buscarPorId(Integer id) {
		return empresaRepository.findById(id);
	}
	
	public void deletarEmpresaPorId(Integer id) {
		empresaRepository.deleteById(id);
	}

	public Empresa atualizarEmpresa(Integer id, Empresa empresa) {
		Empresa empresaSalvar = validarSeExiste(id);
		BeanUtils.copyProperties(empresa, empresaSalvar,"id");
		return empresaRepository.save(empresaSalvar);
	}
	
	private Empresa validarSeExiste(Integer id) {
		Optional<Empresa> empresaOpt = buscarPorId(id);
		if (!empresaOpt.isPresent()) {
			throw new EmptyResultDataAccessException(1);
		}
		return empresaOpt.get();
	}
	
}
