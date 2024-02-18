package bancodedados;

import entidade.Cliente;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BancoDeDados {
    private List<Cliente> clientes;
    private List<Integer> numerosContas;

    public BancoDeDados(){
        this.clientes = new ArrayList<>();
        this.numerosContas = new ArrayList<>();
    }


    public Optional<List<Integer>> getNumerosContas() {
        return Optional.of(numerosContas);
    }

    public void setNumerosContas(Integer numeroConta) {
        this.numerosContas.add(numeroConta);
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void adicionarCliente(Cliente cliente){
        this.clientes.add(cliente);
    }
}
