package com.mjv.digytal.peoplejob.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "tb_habilidade")
public class Habilidade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
}