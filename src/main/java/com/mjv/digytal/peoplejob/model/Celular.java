package com.mjv.digytal.peoplejob.model;

import lombok.Data;

import javax.persistence.Embeddable;

@Data
@Embeddable
public class Celular {
    private String celularNumero;
    private boolean celularWhats;
}


