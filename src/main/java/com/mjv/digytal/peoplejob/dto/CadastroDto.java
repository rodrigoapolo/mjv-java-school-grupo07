package com.mjv.digytal.peoplejob.dto;

import com.mjv.digytal.peoplejob.model.Sexo;

import lombok.Data;

@Data
public class CadastroDto {

	private String nome;
	private String cpf;
	private Sexo sexo;
	private EnderecoDto enderecoDto;
}
