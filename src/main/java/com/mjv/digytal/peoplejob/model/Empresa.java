 package com.mjv.digytal.peoplejob.model;

 import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import javax.persistence.*;

 @Entity
 @Data
 @Table(name = "tb_empresa")
 public class Empresa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Integer id;
    private String nome;
}
