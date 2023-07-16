package com.mjv.digytal.peoplejob.model;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class LeitorArquivoaa {

    private static final String DEFAULT_PATH = "C:\\MJV\\files\\Arquivo2";

    private static final String DELIMITER = ";";
    private static final String DEFAULT_EXTENSION = ".csv";


    public static void criarArquivoCSV() throws IOException {

        Path path = Paths.get(
                DEFAULT_PATH + DEFAULT_EXTENSION);

        path.toFile().createNewFile();

        // ?
        // Lendo o path e convertendo todos os caracteres (bytes) de uma só vez
        byte[] bytesArquivo = Files.readAllBytes(path);

        String conteudo = new String(bytesArquivo);
        System.out.println(conteudo);

        System.out.println("Planilha criada! \n");
    }

    public static void inserirDadosArquivoCSV(List<Cadastro> cadastros, List<Habilidade> habilidades, List<Experiencia> experiencias, List<Profissao> profissoes) {

        try {
            DecimalFormat decimalFormat = new DecimalFormat("#0.00");
            DateTimeFormatter formatarData = DateTimeFormatter.ofPattern("dd/MM/yyyy");

            StringBuilder conteudo = new StringBuilder();

            for (Cadastro cadastro : cadastros) {
                conteudo.append(cadastro.getNome() + DELIMITER);
                conteudo.append(cadastro.getCpf() + DELIMITER);
                conteudo.append(cadastro.getDataNascimento() + DELIMITER);
                conteudo.append(cadastro.getEmail() + DELIMITER);
                conteudo.append(cadastro.getTelefone() + DELIMITER);
                conteudo.append(cadastro.getPretencaoSalarial().getPretencaoMaxima() + DELIMITER);
                conteudo.append(cadastro.getPretencaoSalarial().getPretencaoMinima() + DELIMITER);
                conteudo.append(cadastro.getSexo() + DELIMITER);
                conteudo.append(cadastro.getCelular() + DELIMITER);
                conteudo.append(cadastro.getCelular().isCelularWhats() + DELIMITER);
                conteudo.append(cadastro.getEndereco().getCep() + DELIMITER);
                conteudo.append(cadastro.getEndereco().getLogradouro() + DELIMITER);
                conteudo.append(cadastro.getEndereco().getNumero() + DELIMITER);
                conteudo.append(cadastro.getEndereco().getComplemento() + DELIMITER);
                conteudo.append(cadastro.getEndereco().getBairro() + DELIMITER);
                conteudo.append(cadastro.getEndereco().getCidade().getEstado() + DELIMITER);
                conteudo.append(cadastro.getEndereco().getCidade() + DELIMITER);
                for (Habilidade habilidade : habilidades){
                    conteudo.append(habilidade.getNome() + DELIMITER);
                }
                for (Experiencia experiencia : experiencias){
                    conteudo.append(experiencia.getSalario() + DELIMITER);
                    conteudo.append(experiencia.isEmpregoAtual() + DELIMITER);
                    conteudo.append(experiencia.getDataContratacao() + DELIMITER);
                    conteudo.append(experiencia.getDataDesligamento() + DELIMITER);
                    conteudo.append(experiencia.getRegimeContratacao() + DELIMITER);
                    conteudo.append(experiencia.getEmpresa() + DELIMITER);
                    //conteudo.append(experiencia.getProfissao() + DELIMITER);
                }
                for (Profissao profissao : profissoes){
                    conteudo.append(profissao.getNome() + DELIMITER);
                }

            }


            Path arquivoDestino = Paths.get(DEFAULT_PATH + DEFAULT_EXTENSION);

            Files.write(arquivoDestino, conteudo.toString().getBytes(StandardCharsets.UTF_8) ,StandardOpenOption.CREATE);

        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static String imprimirLeituraArquivoCSV() {

        StringBuilder sb = new StringBuilder();

        try {
            Path arquivoOrigem = Paths.get(
                    DEFAULT_PATH + DEFAULT_EXTENSION);

            List<String> linhas = Files.readAllLines(arquivoOrigem);

            DateTimeFormatter formatarData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            DecimalFormat decimalFormat = new DecimalFormat("#0.00");

            for (int i = 1; i < linhas.size(); i++) {

                String linha = linhas.get(i);
                String[] colunas = linha.split("\\;");

                String nome = colunas[0];
                String cpf = colunas[1];
                LocalDate dataNascimento = LocalDate.parse(colunas[2], formatarData);
                String email = colunas[3];
                Long telefone = Long.valueOf(colunas[4]);

                PretencaoSalarial pretencaoSalarial = new PretencaoSalarial();
                pretencaoSalarial.setPretencaoMinima(Double.valueOf(colunas [5].replace("R$", "").replace(",", ".")));
                pretencaoSalarial.setPretencaoMaxima(Double.valueOf(colunas [6].replace("R$", "").replace(",", ".")));

                Sexo sexo = Sexo.valueOf(colunas[7]);

                Celular celular = new Celular();
                celular.setCelularNumero(String.valueOf(colunas [8]));
                celular.setCelularWhats(Boolean.valueOf(colunas [9]));

                Endereco endereco = new Endereco();
                endereco.setCep(String.valueOf(colunas [10]));
                endereco.setLogradouro(String.valueOf(colunas [11]));
                endereco.setNumero(String.valueOf(colunas [12]));
                endereco.setComplemento(String.valueOf(colunas [13]));
                endereco.setBairro(String.valueOf(colunas [14]));

                Cidade cidade = new Cidade();
                cidade.setEstado(String.valueOf(colunas [15]));
                cidade.setNome(String.valueOf(colunas [16]));

                Habilidade habilidade = new Habilidade();
                habilidade.setNome(String.valueOf(colunas [17]));

                Experiencia experiencia = new Experiencia();
                experiencia.setSalario(Double.valueOf(colunas [18].replace("R$", "").replace(",", ".")));
                experiencia.setEmpregoAtual(Boolean.valueOf(colunas [19]));
                experiencia.setDataContratacao(LocalDate.parse(colunas [20]));
                experiencia.setDataDesligamento(LocalDate.parse(colunas [21]));
                experiencia.setRegimeContratacao(RegimeContratacao.valueOf(String.valueOf(colunas [22])));

                Empresa empresa = new Empresa();
                empresa.setNome(String.valueOf(colunas [23]));

                //experiencia.setProfissao(String.valueOf(colunas [24]));

                Profissao profissao = new Profissao();
                profissao.setNome(String.valueOf(colunas [24]));


                //TODO SALVAR NO BANCO DE DADOS
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }


}
