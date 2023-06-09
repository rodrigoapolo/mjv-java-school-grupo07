public class Conta {
    Double agencia;
    Double numero;
    Double saldo;
    String nome;


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


public Double sacarValor(Double valor) {
if (saldo < valor) {
throw new IllegalArgumentException("Conta não possui saldo!");
}
saldo -= valor;
return valor;

}
  
}