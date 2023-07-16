package com.mjv.digytal.peoplejob.model;

import lombok.Getter;

public enum RegimeContratacao {
    CLT("CLT"),
    PJ("PJ"),
    COP("COP"),
    AUT("AUT");
    @Getter
    private String regimeContratacao;

    RegimeContratacao(String regimeContratacao) {
        this.regimeContratacao = regimeContratacao;
    }
}
