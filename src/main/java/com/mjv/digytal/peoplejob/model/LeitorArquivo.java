package com.mjv.digytal.peoplejob.model;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeitorArquivo{

    public static List<String> obterLinhasCsvCadastros(String caminhoCompleto) throws Exception{
        final Path arquivo = Paths.get(caminhoCompleto);
        List<String> linhas = Files.readAllLines(arquivo);
        return linhas;
    }

    public static List<Cadastro> lerCsvCadastros(String caminhoCompleto) throws Exception{
        List<String> linhas = obterLinhasCsvCadastros(caminhoCompleto);

        List<Cadastro> cadastros = new ArrayList<Cadastro>();
        for(String linha: linhas){

            String [] colunas = linha.split("\\;");


            Cadastro cadastro = new Cadastro();
            cadastro.setNome(colunas [0]);
            cadastro.setCpf(colunas [1]);
            cadastro.setDataNascimento(LocalDate.parse(colunas [2]));

            cadastro.setEmail(colunas [3]);
            cadastro.setTelefone(String.valueOf(colunas [4]));
           // cadastro.setPretencaoSalarial(Double.valueOf(colunas [5]));
            cadastro.setSexo(Sexo.valueOf(colunas [6].toUpperCase()));
            //cadastro.setCelular(String.valueOf(colunas [7]));
            //cadastro.setEndereco(String.valueOf(colunas[8]));

            cadastros.add(cadastro);
        }

        return cadastros;
    }

}
