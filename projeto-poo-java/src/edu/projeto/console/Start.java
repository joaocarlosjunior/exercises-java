package edu.projeto.console;

import edu.projeto.basedados.Banco;
import edu.projeto.entidade.*;
import edu.projeto.negocio.ClienteNegocio;
import edu.projeto.negocio.PedidoNegocio;
import edu.projeto.negocio.ProdutoNegocio;
import edu.projeto.utilidade.LeitoraDados;
import edu.projeto.entidade.*;

import java.util.Optional;

/**
 * Classe responsável por controlar a execução da aplicação.
 *
 * @author João Carlos
 */
public class Start {

    private static Cliente clienteLogado = null;

    private static Banco banco = new Banco();

    private static ClienteNegocio clienteNegocio = new ClienteNegocio(banco);
    private static PedidoNegocio pedidoNegocio = new PedidoNegocio(banco);
    private static ProdutoNegocio produtoNegocio = new ProdutoNegocio(banco);

    /**
     * Método utilitário para inicializar a aplicação.
     *
     * @param args Parâmetros que podem ser passados para auxiliar na execução.
     */
    public static void main(String[] args) {

        System.out.println("Bem vindo ao e-Compras");

        String opcao = "";
        String codigoLivro = "";
        String codigoCaderno = "";
        String codigoPedido = "";

        while (true) {

            if (clienteLogado == null) {

                System.out.println("Já possui cadastro? s/n");
                String login = LeitoraDados.lerDado();

                if (login.equalsIgnoreCase("s")) {
                    System.out.println("Digite o cpf:");

                    String cpf = "";
                    cpf = LeitoraDados.lerDado();

                    identificarUsuario(cpf);
                } else {
                    Cliente novoCliente = LeitoraDados.lerCliente();
                    clienteNegocio.cadastrar(novoCliente);
                    clienteLogado = novoCliente;
                }

            }

            System.out.println("Selecione uma opção:");
            System.out.println("1 - Cadastrar Livro");
            System.out.println("2 - Excluir Livro");
            System.out.println("3 - Consultar Livro");
            System.out.println("4 - Cadastrar Caderno");
            System.out.println("5 - Excluir Caderno");
            System.out.println("6 - Consultar Caderno");
            //TODO Desafio: Consultar Caderno(matéria)
            System.out.println("7 - Fazer pedido");
            System.out.println("8 - Excluir pedido");
            System.out.println("9 - Consultar Pedido");
            //TODO Desafio: Consultar Pedido(código)
            System.out.println("10 - Listar pedidos");
            System.out.println("11 - Listar produtos");
            System.out.println("12 - Deslogar");
            System.out.println("0 - Sair");

            opcao = LeitoraDados.lerDado();

            switch (opcao) {
                case "0":
                    System.exit(0);
                    break;
                case "1":
                    Livro livro = LeitoraDados.lerLivro();
                    produtoNegocio.salvar(livro);
                    break;
                case "2":
                    System.out.println("Digite o código do livro");
                    codigoLivro = LeitoraDados.lerDado();
                    produtoNegocio.excluir(codigoLivro);
                    break;
                case "3":
                    //TODO Consultar livro
                    produtoNegocio.listarTodos();
                    System.out.println("Digite o código do livro");
                    codigoLivro = LeitoraDados.lerDado();
                    Optional<Produto> produtoLivro = produtoNegocio.consultar(codigoLivro);
                    Livro dadosLivro = (Livro) produtoLivro.get();
                    System.out.println(dadosLivro.toString());
                    /*System.out.println("Nome Livro: " + dadosLivro.getNome() + " Genero: " + dadosLivro.getGenero());*/
                    break;
                case "4":
                    //TODO Cadastrar Caderno
                    Caderno caderno = LeitoraDados.lerCaderno();
                    produtoNegocio.salvar(caderno);
                    break;
                case "5":
                    produtoNegocio.listarTodos();
                    System.out.println("Digite codigo do caderno para excluir:");
                    codigoCaderno = LeitoraDados.lerDado();
                    produtoNegocio.excluir(codigoCaderno);
                    break;
                case "6":
                    produtoNegocio.listarTodos();
                    System.out.println("Digite codigo do caderno para consulta:");
                    codigoCaderno = LeitoraDados.lerDado();
                    Optional<Produto> produtoCaderno = produtoNegocio.consultar(codigoCaderno);
                    Caderno dadosCaderno = (Caderno) produtoCaderno.get();
                    System.out.println("Caderno de " + dadosCaderno.getMateria().getFator() + " materias");
                    break;
                case "7":
                    produtoNegocio.listarTodos();
                    Pedido pedido = LeitoraDados.lerPedido(banco);
                    pedidoNegocio.salvar(pedido, clienteLogado);
                    break;
                case "8":
                    pedidoNegocio.listarPedidos();
                    codigoPedido = LeitoraDados.lerDado();
                    pedidoNegocio.excluir(codigoPedido);
                    break;
                case "9":
                    pedidoNegocio.listarPedidos();
                    codigoPedido = LeitoraDados.lerDado();
                    pedidoNegocio.consultar(codigoPedido);
                    break;
                case "10":
                    pedidoNegocio.listarPedidos();
                    break;
                case "11":
                    produtoNegocio.listarTodos();
                case "12":
                    clienteLogado = null;
                    break;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        }
    }

    /**
     * Procura o usuário na base de dados.
     *
     * @param cpf CPF do usuário que deseja logar na aplicação
     */
    private static void identificarUsuario(String cpf) {

        Optional<Cliente> resultado = clienteNegocio.consultar(cpf);

        if (resultado.isPresent()) {

            Cliente cliente = resultado.get();
            System.out.println(String.format("Olá %s! Você está logado.", cliente.getNome()));
            clienteLogado = cliente;
        } else {
            System.out.println("Usuário não cadastrado.");
            System.exit(0);
        }
    }
}
