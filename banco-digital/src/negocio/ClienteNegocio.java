package negocio;

import bancodedados.BancoDeDados;
import entidade.Cliente;

import java.util.Optional;

public class ClienteNegocio {

    private BancoDeDados banco;


    public ClienteNegocio(BancoDeDados banco) {
        this.banco = banco;
    }

    public void adicionarCliente(Cliente cliente) {
        if (banco.getClientes().contains(cliente)) {
            System.out.println("Cliente já cadastrado!!");
        } else {
            banco.adicionarCliente(cliente);
            System.out.println("Cliente cadastrado com sucesso!!");
        }
    }

    public Optional<Cliente> consultarCliente(String codigo) {
        for (Cliente cliente : banco.getClientes()) {
            if (cliente.getCpf().equalsIgnoreCase(codigo)) {
                return Optional.of(cliente);
            }
        }
        return Optional.empty();
    }

    public void listarClientes(){
        for (Cliente cliente: banco.getClientes()){
            System.out.println(cliente.toString());
        }
    }
}
