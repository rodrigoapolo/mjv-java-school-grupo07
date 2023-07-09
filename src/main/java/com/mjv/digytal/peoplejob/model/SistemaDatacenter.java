package com.mjv.digytal.peoplejob.model;

import java.util.List;

public class SistemaDatacenter {
    public static void main(String[] args) {

        lerAquivoCsv();
    }

    private static void lerAquivoCsv() {
        try {
            List<Cadastro> cadastros = com.mjv.digytal.peoplejob.model.LeitorArquivo.lerCsvCadastros("C:\\jobby\\files\\cadastros.csv");
            for(Cadastro cad: cadastros) {
                System.out.println(cad);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}