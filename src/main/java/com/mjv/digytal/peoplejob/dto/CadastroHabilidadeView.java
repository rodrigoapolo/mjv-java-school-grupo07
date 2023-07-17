package com.mjv.digytal.peoplejob.dto;

import java.time.LocalDate;
import java.util.List;

import com.mjv.digytal.peoplejob.model.Habilidade;

public interface CadastroHabilidadeView {

	String getNome();
	String getCpf();
	LocalDate getDataNascimento();
	String getEmail();
	String getTelefone();
	List<Habilidade> getHabilidades();
	
}
