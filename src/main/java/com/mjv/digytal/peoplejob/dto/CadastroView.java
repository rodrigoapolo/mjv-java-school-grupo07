package com.mjv.digytal.peoplejob.dto;

import java.time.LocalDate;


public interface CadastroView {

	String getNome();
	String getCpf();
	LocalDate getDataNascimento();
	String getEmail();
	String getTelefone();
	
}
