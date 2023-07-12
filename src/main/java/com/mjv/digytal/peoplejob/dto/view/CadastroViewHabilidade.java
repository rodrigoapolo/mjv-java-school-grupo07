package com.mjv.digytal.peoplejob.dto.view;

import java.time.LocalDate;

import com.mjv.digytal.peoplejob.model.Habilidade;

public interface CadastroViewHabilidade {

	String getNome();
	String getCpf();
	LocalDate getDataNascimento();
	String getEmail();
	String getTelefone();
	Habilidade getHabilidades();
	
}
