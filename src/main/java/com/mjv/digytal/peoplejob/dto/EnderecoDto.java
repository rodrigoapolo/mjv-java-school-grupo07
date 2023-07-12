package com.mjv.digytal.peoplejob.dto;

import lombok.Data;

@Data
public class EnderecoDto {

    private String cep;
    private String logradouro;
    private String numero;
    private String complemento;
    private String bairro;
    private CidadeDto cidadeDto;
}
