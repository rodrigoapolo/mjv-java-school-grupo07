package com.mjv.digytal.peoplejob.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "tb_profissao")
public class Profissao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
}
