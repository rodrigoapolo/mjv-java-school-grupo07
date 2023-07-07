package com.mjv.digytal.peoplejob.model;

import lombok.Getter;

public enum Sexo {
    MASCULINO('M'),
    FEMININO('F');
    @Getter
    private Character sexo;
    Sexo(Character sexo) {
        this.sexo = sexo;
    }
}
