package com.mjv.digytal.peoplejob.model;

public class Celular {
    private long numero;
    private boolean celularWhats; 
    
    public Celular(long numero, boolean celularWhats) {
        this.numero = numero;
        this.celularWhats = celularWhats;
    }

    public long getNumero() {
        return numero;
    }

    public void setNumero(long numero){
        this.numero = numero;
    }

    public boolean getCelularWhats() {
        return celularWhats;
    }

    public void setCelularWhats(boolean celularWhats) {
        this.celularWhats = celularWhats;
    }
}


