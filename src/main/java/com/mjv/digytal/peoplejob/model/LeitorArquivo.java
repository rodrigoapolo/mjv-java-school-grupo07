package com.mjv.digytal.peoplejob.model;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class LeitorArquivo{

    public static List<String> obterLinhasCsvCadastros(String caminhoCompleto) throws Exception{
        final Path arquivo = Paths.get(caminhoCompleto);
        List<String> linhas = Files.readAllLines(arquivo);
        return linhas;
    }

    private static PretencaoSalarial setPretencaoMinima(Double aDouble){
        return null;
    }

    private static PretencaoSalarial setPretancaoMaxima(Double aDouble){
        return null;
    }

    private static Celular setCelularNumero(String s) {
        return null;
    }

    private static Celular setCelularWhats(Boolean s){
        return null;
    }

    public static Endereco setEndereco(String s){
        return null;
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
            cadastro.setPretencaoSalarial(setPretencaoMinima(Double.valueOf(colunas [5])));
            cadastro.setPretencaoSalarial(setPretancaoMaxima(Double.valueOf(colunas [6])));
            cadastro.setSexo(Sexo.valueOf(colunas [7].toUpperCase()));
            cadastro.setCelular(setCelularNumero(String.valueOf(colunas [8])));
            cadastro.setCelular(setCelularWhats(Boolean.valueOf(colunas [9])));
            cadastro.setEndereco(setEndereco(String.valueOf(colunas [10])));

            cadastros.add(cadastro);
        }

        return cadastros;
    }

}
