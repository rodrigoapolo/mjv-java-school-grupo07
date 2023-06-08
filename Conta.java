public class Conta {

private Long numero;
double saldo;
private String nome;

public consultarSaldoAtual(){
    System.out.println(saldo);
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

}