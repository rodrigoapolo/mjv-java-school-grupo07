package com.mjv.digytal.peoplejob.dto;

import java.time.LocalDate;

import com.mjv.digytal.peoplejob.model.Experiencia;

public interface CadastroExperienciaView {

	String getNome();
	String getCpf();
	LocalDate getDataNascimento();
	String getEmail();
	String getTelefone();
	Experiencia getExperiencias();
	
}
