package edu.projeto.negocio;

import edu.projeto.basedados.Banco;
import edu.projeto.entidade.Cliente;

import java.util.Optional;

/**
 * Classe para manipular a entidade {@link Cliente}.
 *
 * @author João Carlos
 */
public class ClienteNegocio {

    /**
     * {@inheritDoc}.
     */
    private Banco bancoDados;

    /**
     * Construtor.
     *
     * @param banco Banco de dados para ter acesso aos clientes cadastrados
     */
    public ClienteNegocio(Banco banco) {
        this.bancoDados = banco;
    }

    /**
     * Consulta o cliente pelo seu CPF.
     *
     * @param cpf CPF de um cliente
     * @return O cliente que possuir o CPF passado.
     */
    public Optional<Cliente> consultar(String cpf) {

        for (Cliente cliente: bancoDados.getClientes()){
            if(cliente.getCpf().equals(cpf)){
                return Optional.of(cliente);
            }
        }
        return Optional.empty();
    }

    /**
     * Cadastra um novo cliente.
     *
     * @param cliente Novo cliente que terá acesso a aplicação
     */
    //TODO Fazer a inclusão de cliente
    public void cadastrar(Cliente cliente) {
        if (cliente == null) {
            System.out.println("Erro.  Informa dados cliente");
        } else {
            bancoDados.adicionarCliente(cliente);
        }
    }

    /**
     * Exclui um cliente específico.
     * @param cpf CPF do cliente
     */
    //TODO Fazer a exclusão de cliente

}
