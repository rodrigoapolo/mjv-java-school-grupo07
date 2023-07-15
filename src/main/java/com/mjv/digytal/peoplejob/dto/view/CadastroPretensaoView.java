package com.mjv.digytal.peoplejob.dto.view;

import java.time.LocalDate;

import com.mjv.digytal.peoplejob.model.PretencaoSalarial;

public interface CadastroPretensaoView {

	String getNome();
	String getCpf();
	LocalDate getDataNascimento();
	String getEmail();
	String getTelefone();
	PretencaoSalarial getPretencaoSalarial();
}
