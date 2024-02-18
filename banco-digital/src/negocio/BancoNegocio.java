package negocio;

import bancodedados.BancoDeDados;
import entidade.Cliente;
import entidade.Conta;
import entidade.ContaCorrente;
import entidade.ContaPoupanca;
import leitordedados.LeitorDeDados;


import java.util.Optional;
import java.util.Random;

public class BancoNegocio {
    private BancoDeDados banco;

    public BancoNegocio(BancoDeDados banco) {
        this.banco = banco;
    }

    public void transferirValor(Cliente clienteTransferir, Conta contaReceber) {
        Double valor = LeitorDeDados.lerValor();

        if (clienteTransferir.getConta().isPresent() && clienteTransferir.getConta().isPresent()) {
            clienteTransferir.getConta().get().transferir(contaReceber, valor);
            System.out.println("Transferência realizada com sucesso!");
        } else {
            System.out.println("Erro ao transferir.");
        }
    }

    public void depositar(Cliente cliente) {
        Double valor = LeitorDeDados.lerValor();

        if (cliente.getConta().isPresent()) {
            cliente.getConta().get().depositar(valor);
            System.out.println("Valor Depositado com sucesso!");
        } else {
            System.out.println("Erro ao depositar.");
        }
    }

    public void sacar(Cliente cliente) {
        Double valor = LeitorDeDados.lerValor();

        if (cliente.getConta().isPresent()) {
            cliente.getConta().get().sacar(valor);
            System.out.println("Valor Sacado com sucesso!");
        }else{
            System.out.println("Erro ao sacar.");
        }
    }

    public void adicionarContaCliente(Cliente cliente) {
        System.out.println("Temos duas opções de contas (Corrente e Poupança):");
        System.out.println("1 - Para criar Conta Corrente.");
        System.out.println("2 - Para criar Conta Poupança.");

        int opcao;
        boolean isValid = false;

        while (!isValid) {
            opcao = Integer.parseInt(LeitorDeDados.lerDados());
            switch (opcao) {
                case 1:
                    Conta conta = criarContaCorrente();
                    cliente.setConta(conta);
                    isValid = true;
                    break;
                case 2:
                    ContaPoupanca contaPoupanca = new ContaPoupanca();
                    cliente.setConta(contaPoupanca);
                    isValid = true;
                    break;
                default:
                    System.out.println("Código errado! Digite novamente...");
                    break;
            }
        }

    }

    public void visualizarSaldo(Cliente cliente) {
        if (cliente.getConta().isPresent()){
            System.out.printf("Saldo Atual: %.2f\n", cliente.getConta().get().getSaldo());
        }else{
            System.out.println("Erro ao visualizar saldo.");
        }
    }

    public Optional<Cliente> consultarConta(String numeroConta) {
        for (Cliente cliente : banco.getClientes()) {
            if (cliente.getConta().isPresent() && cliente.getConta().get().getNumero().equals(numeroConta)) {
                return Optional.of(cliente);
            } else {
                System.out.println("Erro ao consultar conta.");
            }
        }
        return Optional.empty();
    }

    private Conta criarContaCorrente() {
        ContaCorrente contaCorrente = new ContaCorrente();
        Integer numeroConta = gerarNumeroConta();

        String format = "%04d";
        contaCorrente.setNumero(String.format(format, numeroConta));
        banco.setNumerosContas(numeroConta);

        return contaCorrente;
    }

    private Integer gerarNumeroConta() {
        Random random = new Random();
        Integer numeroConta;

        do {
            numeroConta = random.nextInt(8999);
        } while (banco.getNumerosContas().isPresent() && banco.getNumerosContas().get().contains(numeroConta));

        return numeroConta;
    }
}
