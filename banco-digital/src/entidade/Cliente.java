package entidade;

import java.util.Objects;
import java.util.Optional;

public class Cliente {
    private String nome;
    private String cpf;

    private Conta conta;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Optional<Conta> getConta() {
        return Optional.ofNullable(conta);
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cliente cliente)) return false;
        return Objects.equals(getCpf(), cliente.getCpf());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCpf());
    }

    @Override
    public String toString() {
        /*String[] tipoConta = conta.getClass().getName().split("(?=[A-Z])");*/
        return "Cliente: " + this.nome + " CPF: " + this.cpf + " " + conta.getClass().getName() + "  " + conta;
    }
}
