package com.mjv.digytal.peoplejob.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JoinTable(name="profissao_cadastro",
            joinColumns={@JoinColumn(name="cadastro_ID")},
            inverseJoinColumns={@JoinColumn(name="profissao_ID")})
    private Profissao profissao;

    @Setter(AccessLevel.PRIVATE)
    @ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JoinTable(name="habilidade_cadastro",
            joinColumns={@JoinColumn(name="cadastro_ID")},
            inverseJoinColumns={@JoinColumn(name="habilidade_ID")})
    private List<Habilidade> habilidades = new ArrayList<>();

    @OneToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JoinColumn(name = "cadastro_id",referencedColumnName = "id")
    private List<Experiencia> experiencia;

}




