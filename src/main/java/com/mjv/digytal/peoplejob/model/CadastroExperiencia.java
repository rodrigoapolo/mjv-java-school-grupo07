package com.mjv.digytal.peoplejob.model;

import java.time.LocalDate;
import java.util.ArrayList;

public class CadastroExperiencia {
    private int id;
    private double salario;
    private boolean empregoAtual;
    private LocalDate dataContratacao;
    private LocalDate dataDesligamento;
    private RegimeContratacao regimeContratacao;
    private Empresa empresa;
    private ArrayList<Profissao> profissao = new ArrayList<Profissao>();

    public CadastroExperiencia(int id, double salario, boolean empregoAtual, LocalDate dataContratacao, LocalDate dataDesligamento, RegimeContratacao regimeContratacao, Empresa empresa) {
        this.id = id;
        this.salario = salario;
        this.empregoAtual = empregoAtual;
        this.dataContratacao = dataContratacao;
        this.dataDesligamento = dataDesligamento;
        this.regimeContratacao = regimeContratacao;
        this.empresa = empresa;
    }

    public int getId() {
        return id;
    }
     
    public void setId( int id){
        this.id = id;
    }

    public double getSalario(){
        return salario;
    }

    public void setSalario( double salario){
        this.salario = salario;
    }

    public boolean getEmpregoAtual() {
        return empregoAtual;
    }

    public void setEmpregoAtual( boolean empregoAtual) {
         this.empregoAtual = empregoAtual;
    }

    public LocalDate getDataContratacao() {
        return dataContratacao;
    }

    public void setDataContratacao( LocalDate dataContratacao) {
        this.dataContratacao = dataContratacao;
    }

    public LocalDate getDataDesligamento() {
        return dataDesligamento;
    }

    public void setDataDesligamento( LocalDate dataDesligamento) {
        this.dataDesligamento = dataDesligamento;
    }
    
    public RegimeContratacao getRegimeContratacao() {
        return regimeContratacao;
    }

    public void setRegimeContratacao(RegimeContratacao regimeContratacao){
        this.regimeContratacao = regimeContratacao;
    }

    public Empresa getEmpresa(){
        return empresa;
    }

    public void setEmpresa(Empresa empresa){
        this.empresa = empresa;
    }
    
    public ArrayList<Profissao> getProfissao(){
        return profissao;
    }

    public void setProfissao(ArrayList<Profissao> profissao) {
        this.profissao = profissao;
    }
    
}
