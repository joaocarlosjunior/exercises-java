package entidade;

public class ContaPoupanca extends Conta {
    @Override
    public void transferir(Conta conta, Double valor) {
        if(getSaldo() >= valor){
            sacar(valor);
            conta.depositar(valor);
        }else{
            System.out.println("Saldo Conta Poupança insuficiente!");
        }
    }
}

