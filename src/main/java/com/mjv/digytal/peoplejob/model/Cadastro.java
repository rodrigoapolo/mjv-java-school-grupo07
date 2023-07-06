package com.mjv.digytal.peoplejob.model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Cadastro { 
    private String nome;    
    private String cpf;
    private LocalDate dataNascimento;    
    private String email;
    private long telefone;
    private ArrayList<String> habilidades = new ArrayList<String>();
    
    private ArrayList<Profissao> profissao = new ArrayList<Profissao>();
    private PretencaoSalarial pretencaoSalarial;
    private Sexo sexo;
    private Celular celularPessoal;
    private Celular celularProfissional;
    private Endereco endereco; 
    private CadastroExperiencia cadastroExperiencia;

    public Cadastro(String nome, String cpf, LocalDate dataNascimento, String email, long telefone, ArrayList<String> habilidades, ArrayList<Profissao> profissao, PretencaoSalarial pretencaoSalarial, Sexo sexo, Celular celularPessoal, Celular celularProfissional, Endereco endereco, CadastroExperiencia cadastroExperiencia) {  
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.email = email;
        this.telefone = telefone;
        this.habilidades.addAll(habilidades);
        this.profissao.addAll(profissao);
        this.pretencaoSalarial = pretencaoSalarial;
        this.sexo = sexo;
        this.celularPessoal = celularPessoal;
        this.celularProfissional = celularProfissional;
        this.endereco = endereco;
        this.cadastroExperiencia = cadastroExperiencia;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf){
        this.cpf = cpf;
    }

    public LocalDate getDataNascimento(){
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento){
        this.dataNascimento = dataNascimento;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public long getTelefone(){
        return telefone;
    }

    public void setTelefone(long telefone){
        this.telefone = telefone;
    }

    public ArrayList<String> getHabilidades(){
        return habilidades;
    }

    public void setHabilidades(ArrayList<String> habilidades){
        this.habilidades = habilidades;
    }

    public ArrayList<Profissao> getProfissao(){
        return profissao;
    }

    public void setProfissao(ArrayList<Profissao> profissao) {
        this.profissao = profissao;
    }

    public PretencaoSalarial getPretencaoSalarial(){
        return pretencaoSalarial;
    }

    public void setPretencaoSalarial(PretencaoSalarial pretencaoSalarial){
        this.pretencaoSalarial = pretencaoSalarial;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo){
        this.sexo = sexo;
    }

    public Celular getCelularPessoal(){
        return celularPessoal;
    }

    public void setCelularPessoal(Celular celular){
        this.celularPessoal = celular;
    }

    public Celular getCelularProfissional(){
        return celularProfissional;
    }

    public void setCelularProfissional(Celular celular){
        this.celularProfissional = celular;
    }
    
    public Endereco getEndereco(){
        return endereco;
    }

    public void setEndereco(Endereco endereco){
        this.endereco = endereco;
    }

    public CadastroExperiencia getCadastroExperiencia(){
        return cadastroExperiencia;
    }
    public void setCadastroExperiencia(CadastroExperiencia cadastroExperiencia){
        this.cadastroExperiencia = cadastroExperiencia;
    }
}




