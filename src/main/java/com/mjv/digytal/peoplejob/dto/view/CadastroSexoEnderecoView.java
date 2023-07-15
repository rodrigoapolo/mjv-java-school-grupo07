package com.mjv.digytal.peoplejob.dto.view;

import com.mjv.digytal.peoplejob.model.Sexo;

public interface CadastroSexoEnderecoView {


	String getNome();
	String getCpf();
	Sexo getSexo();
	EnderecoCidadeView getEndereco();
	
}
