package com.mjv.digytal.peoplejob.model;

public class Cidade {
    private int id;
    private String nome;
    private String estado;
    private String sigla;

    public Cidade(int id, String nome, String estado, String sigla) {
        this.id = id;
        this.nome = nome;
        this.estado = estado;
        this.sigla = sigla;
    }
    public int getId(){
        return id;
    }

    public void setId (int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado){
        this.estado = estado;
    }

    public String  getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }
}
