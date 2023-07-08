package com.mjv.digytal.peoplejob.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "tb_cidade")
public class Cidade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String estado;
    private String sigla;
}
