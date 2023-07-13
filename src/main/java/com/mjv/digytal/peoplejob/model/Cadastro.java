package com.mjv.digytal.peoplejob.model;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

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
    @ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JoinTable(name="profissao_cadastro",
            joinColumns={@JoinColumn(name="cadastro_ID")},
            inverseJoinColumns={@JoinColumn(name="profissao_ID")})
    private Set<Profissao> profissao = new LinkedHashSet<>();

    @Setter(AccessLevel.PRIVATE)
    @ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JoinTable(name="habilidade_cadastro",
            joinColumns={@JoinColumn(name="cadastro_ID")},
            inverseJoinColumns={@JoinColumn(name="habilidade_ID")})
    private Set<Habilidade> habilidades = new LinkedHashSet<>();

    @Setter(AccessLevel.PRIVATE)
    @OneToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JoinColumn(name = "cadastro_id",referencedColumnName = "id")
    private List<Experiencia> experiencias = new LinkedList<>();

}




