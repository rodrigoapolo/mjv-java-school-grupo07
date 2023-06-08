public class Conta {

private Long numero;
double saldo;
private String nome;

public consultarSaldoAtual(){
    System.out.println(saldo);
}

public void cancelarContaJustificativa(String justificativa){

    // Justificativa default
    if(justificativa == null || justificativa.isEmpty()){
        justificativa = "Gostaria de cancelar por motivos pessoais.";
    }

    System.out.println("Conta cancelada com sucesso!");
    System.out.println("Justificativa de cancelamento: " + justificativa);
     
 }

}