package com.mjv.digytal.peoplejob.model;


public class Endereco {
    private long cep;
    private String logradouro;
    private String numero;
    private String complemento;
    private String bairro;
    private Cidade cidade;

    public Endereco(long cep, String logradouro, String numero, String complemento, String bairro, Cidade cidade){
        this.cep = cep;
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cidade = cidade;
    }

    public long getCep(){
        return cep;
    }

    public void setCep(long cep) {
        this.cep = cep;
    }

    public String getLogradouro(){
        return logradouro;
    }

    public void setLogradouro(String logradouro){
        this.logradouro = logradouro;
    }

    public String getNumero(){
        return numero;
    }

    public void setNumero( String numero){
        this.numero = numero;
    }

    public String getComplemento(){
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro(){
        return bairro;
    }

    public void setBairro(String bairro){
        this.bairro = bairro;
    }
   
    public Cidade getCidade(){
        return cidade;
    }

    public void setCidade(Cidade cidade){
        this.cidade = cidade;
    }
}
