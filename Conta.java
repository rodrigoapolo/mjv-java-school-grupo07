public class Conta {

private Long numero;
double saldo;
private String nomeCliente;

public consultarSaldoAtual(){
    System.out.println(saldo);
}


public void cancelarContaJustificativa(String justificativa){
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