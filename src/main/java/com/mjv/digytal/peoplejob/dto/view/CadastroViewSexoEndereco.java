package com.mjv.digytal.peoplejob.dto.view;

import com.mjv.digytal.peoplejob.model.Sexo;

public interface CadastroViewSexoEndereco {


	String getNome();
	String getCpf();
	Sexo getSexo();
	EnderecoViewCidade getEndereco();
	
}
