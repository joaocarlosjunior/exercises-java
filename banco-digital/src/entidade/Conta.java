package entidade;

import java.util.Objects;
import java.util.Random;

public abstract class Conta {
    private final String AGENCIA = String.valueOf(2200);
    private String numero;
    private Double saldo;


    public Conta(){
        this.saldo = 0.0;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getNumero() {
        return numero;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void depositar(Double valor){
        this.saldo+= valor;
    }

    public void sacar(Double valor){
        if(this.saldo >= valor){
            this.saldo-=valor;
        }else{
            System.out.println("Saldo Insuficiente");
        }
    }

    public abstract void transferir(Conta conta, Double valor);

    @Override
    public String toString() {
        return "Agencia: " + AGENCIA + " Numero da Conta: " + numero + " Saldo: " + saldo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Conta conta)) return false;
        return Objects.equals(getNumero(), conta.getNumero());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNumero());
    }
}
