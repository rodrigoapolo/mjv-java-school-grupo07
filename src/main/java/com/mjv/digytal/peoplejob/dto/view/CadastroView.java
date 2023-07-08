package com.mjv.digytal.peoplejob.dto.view;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;


public interface CadastroView {

	String getNome();
	
	String getCpf();
	
	LocalDate getDataNascimento();
	
	String getEmail();
	
	String getTelefone();
	
	
}
