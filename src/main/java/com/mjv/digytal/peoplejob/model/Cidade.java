package com.mjv.digytal.peoplejob.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Data
@Table(name = "tb_cidade")
public class Cidade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.PRIVATE)
    private Integer id;
    private String nome;
    private String estado;
    private String sigla;
}
