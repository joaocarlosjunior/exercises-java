package entidade;

public class ContaCorrente extends Conta{
    @Override
    public void transferir(Conta conta, Double valor) {
        if(getSaldo() >= valor){
            sacar(valor);
            conta.depositar(valor);
        }else{
            System.out.println("Saldo Conta Corrente insuficiente!");
        }
    }
}
