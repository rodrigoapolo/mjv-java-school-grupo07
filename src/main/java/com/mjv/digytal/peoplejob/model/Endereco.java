package com.mjv.digytal.peoplejob.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Embeddable
public class Endereco {
    private String cep;
    private String logradouro;
    private String numero;
    private String complemento;
    private String bairro;
    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE}, fetch = FetchType.EAGER)
    @JoinColumn(name = "cidade_id",referencedColumnName = "id")
    private Cidade cidade;
}

