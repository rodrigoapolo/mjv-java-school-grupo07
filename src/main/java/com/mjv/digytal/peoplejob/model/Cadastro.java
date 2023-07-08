package com.mjv.digytal.peoplejob.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.*;

@Entity
@Data
@Table(name = "tb_cadastro")
public class Cadastro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;    
    private String cpf;
    private LocalDate dataNascimento;    
    private String email;
    private String telefone;
    private PretencaoSalarial pretencaoSalarial;
    @Enumerated(EnumType.STRING)
    private Sexo sexo;
    private Celular celular;
    @Embedded
    private Endereco endereco;

    @Setter(AccessLevel.PRIVATE)
    @OneToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JoinColumn(name = "cadastro_id",referencedColumnName = "id")
    private Set<Profissao> profissao = new LinkedHashSet<>();

    @Setter(AccessLevel.PRIVATE)
    @ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JoinTable(name="habilidade_cadastro",
            joinColumns={@JoinColumn(name="cadastro_ID")},
            inverseJoinColumns={@JoinColumn(name="habilidade_ID")})
    private Set<Habilidade> habilidades = new LinkedHashSet<>();

    @OneToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JoinColumn(name = "experiencia_id",referencedColumnName = "id")
    private Experiencia experiencia;

}




