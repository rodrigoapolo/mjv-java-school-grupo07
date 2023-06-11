// Importação do scanner, array, data e formatador de datas
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.text.ParseException;

public class Conta {
    // Criação de um scanner para receber os dados do usuário
    Scanner sc = new Scanner(System.in);
    

    Long agencia;
    Long numero;
    Double saldo;
    String nome;

    // Variável data de nascimento;
    String dataNascimento;

    // Declarando o formatador de datas
    SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");

    // Criação do array de extratos com valor e data
    ArrayList<extratosAntigos> listaExtratos = new ArrayList<extratosAntigos>(){
        {
            // esse try catch apareceu como correção automatica do java, não sei pq
            try {
                // adicionando os extratos antigos no array            
                add(new extratosAntigos(0, 500.15, formatoData.parse("10/03/2019")));
                add(new extratosAntigos(1, 200.56, formatoData.parse("30/11/2019")));
                add(new extratosAntigos(2, 1000.34, formatoData.parse("30/04/2020")));
                add(new extratosAntigos(3, 2000.00, formatoData.parse("15/05/2021")));
                add(new extratosAntigos(4, 1460.55, formatoData.parse("12/11/2022")));

                // criando uma variável de texto com a atual
                String dataTexto = formatoData.format(new Date());
                add(new extratosAntigos(5, saldo, formatoData.parse(dataTexto)));      
            }
            catch(ParseException e){
                e.printStackTrace();
                System.out.print("you get the ParseException");
            }
                  
        }
    };

    // função para exibir o extrato
    public void extratoEntreDuasDatas() {
        // obtendo as datas para filtrar
        System.out.println("Digite a primeira data em formato dd/mm/yyyy");
        String valor1 = sc.nextLine();
        System.out.println("Digite a segunda data em formato dd/mm/yyyy");
        String valor2 = sc.nextLine();

        // passando por cada data dos extratos para verificação
        for (int i = 0; i < listaExtratos.size(); i++){;
            // novamente, o erro que colocou esse try catch automático
            try {
                Date data1 = formatoData.parse(valor1);
                Date data2 = formatoData.parse(valor2);

                // verificação
                if (listaExtratos.get(i).data.compareTo(data1) > 0 && listaExtratos.get(i).data.compareTo(data2) < 0) {
                    System.out.printf("Data: "+ formatoData.format(listaExtratos.get(i).data) + "Valor: %.2f\n", listaExtratos.get(i).valor);
                }
            } catch (ParseException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }             
        }
    }



    public void consultarSaldoAtual() {
        System.out.println(saldo);
    }

    public void transferir(double valor) {

    }

    public void cancelarContaJustificativa(String justificativa){

        if(existeConta()){

            System.out.println("Conta cancelada com sucesso!");

            // Justificativa default
            if (justificativa == null || justificativa.trim().isEmpty()) {
                justificativa = "Gostaria de cancelar por motivos pessoais.";
            }
            
            System.out.println("Justificativa de cancelamento: " + justificativa);

        } else {
            System.out.println("Erro");
        }
    }

    // Verifica se a conta existe
    // Método simples, só para ilustrar
    public boolean existeConta(){
        return true;
    }


    public double sacarValor(double valor) {
        if (saldo < valor) {
            throw new IllegalArgumentException("Conta não possui saldo!");
        }

        saldo -= valor;
        return valor;
    }
  
}

// criação do tipo extratos antigos
class extratosAntigos {
    // valores do tipo
    public int id;
    public double valor;
    public Date data;

    // construtor do tipo
    public extratosAntigos(int startId, double startValor, Date startDate){
        id = startId;
        valor = startValor;
        data = startDate;
    }
    
}