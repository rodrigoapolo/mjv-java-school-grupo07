public class Conta {

private Long numero;
double saldo;

public consultarSaldoAtual(){
    System.out.println(saldo);
}

public Double sacarValor(Double valor) {
if (saldo < valor) {
throw new IllegalArgumentException("Conta não possui saldo!");
}
saldo -= valor;
return valor;
}