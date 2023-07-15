package com.mjv.digytal.peoplejob.dto.view;

import java.time.LocalDate;

import com.mjv.digytal.peoplejob.model.Profissao;

public interface CadastroProfissaoView {

	String getNome();
	String getCpf();
	LocalDate getDataNascimento();
	String getEmail();
	String getTelefone();
	Profissao getProfissao();
	
}
