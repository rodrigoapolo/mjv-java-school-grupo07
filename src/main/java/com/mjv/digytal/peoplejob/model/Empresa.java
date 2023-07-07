 package com.mjv.digytal.peoplejob.model;

 import lombok.Data;

 import javax.persistence.*;

 @Entity
 @Data
 @Table(name = "tb_empresa")
 public class Empresa {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
}
