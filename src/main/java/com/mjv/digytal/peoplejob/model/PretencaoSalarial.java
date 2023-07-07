package com.mjv.digytal.peoplejob.model;

import lombok.Data;

import javax.persistence.Embeddable;

@Data
@Embeddable
public class PretencaoSalarial {
    private Double pretencaoMinima;
    private Double pretencaoMaxima;
}
