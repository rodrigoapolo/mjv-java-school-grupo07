package com.mjv.digytal.peoplejob.dto.view;

import java.time.LocalDate;

import com.mjv.digytal.peoplejob.model.PretencaoSalarial;

public interface CadastroViewPretensao {

	String getNome();
	String getCpf();
	LocalDate getDataNascimento();
	String getEmail();
	String getTelefone();
	PretencaoSalarial getPretencaoSalarial();
}
