package com.mjv.digytal.peoplejob.dto;

import com.mjv.digytal.peoplejob.model.Sexo;

public interface CadastroDto {

	String getNome();
	String getCpf();
	Sexo getSexo();
	EnderecoDto getEndereco();
	
}
