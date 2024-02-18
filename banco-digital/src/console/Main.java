package console;

import bancodedados.BancoDeDados;
import entidade.Cliente;
import leitordedados.LeitorDeDados;
import negocio.ClienteNegocio;
import negocio.BancoNegocio;

import java.util.Optional;

public class Main {
    private static final BancoDeDados BANCODEDADOS = new BancoDeDados();
    private static final ClienteNegocio CLIENTE_NEGOCIO = new ClienteNegocio(BANCODEDADOS);
    private static final BancoNegocio BANCO_NEGOCIO = new BancoNegocio(BANCODEDADOS);
    private static Cliente clienteLogado = null;


    public static void main(String[] args) {

        System.out.println("---BEM VINDO---");

        while (true){
            if(clienteLogado == null){
                System.out.println("Já possui conta?(s/n)");
                String opcao = LeitorDeDados.lerDados();

                if(opcao.equalsIgnoreCase("n")){
                    Cliente cliente = LeitorDeDados.lerCliente();
                    CLIENTE_NEGOCIO.adicionarCliente(cliente);
                    clienteLogado = cliente;
                }else if(opcao.equalsIgnoreCase("s")){
                    System.out.println("Digite CPF:");
                    String cpf = LeitorDeDados.lerDados();

                    verificarUsuario(cpf);
                }else{
                    System.out.println("Erro ao digitar opção! Tente novamente...");
                }
            }


            if(clienteLogado.getConta().isPresent()){
                System.out.println("Olá " + clienteLogado.getNome());
                System.out.println("--DESEJA REALIZAR QUAL OPERAÇÃO--");
                System.out.println("1 - Visualizar Saldo");
                System.out.println("2 - Deposito");
                System.out.println("3 - Saque");
                System.out.println("4 - Transferência");
                System.out.println("5 - Deslogar");
                System.out.println("0 - SAIR");
                String opcao = LeitorDeDados.lerDados();

                switch (opcao){
                    case "0":
                        System.out.println("Volte Sempre.");
                        System.exit(0);
                        break;
                    case "1":
                        BANCO_NEGOCIO.visualizarSaldo(clienteLogado);
                        break;
                    case "2":
                        BANCO_NEGOCIO.depositar(clienteLogado);
                        break;
                    case "3":
                        BANCO_NEGOCIO.sacar(clienteLogado);
                        break;
                    case "4":
                        System.out.println("Informe número da conta do recebedor:");
                        String contaAReceber = LeitorDeDados.lerDados();
                        Optional<Cliente> cliente = BANCO_NEGOCIO.consultarConta(contaAReceber);

                        if (cliente.isPresent()){
                            BANCO_NEGOCIO.transferirValor(clienteLogado,cliente.get().getConta().get());
                        }else{
                            System.out.println("Conta inexistente ou digitado errado!!");
                        }
                        break;
                    case "5":
                        clienteLogado = null;
                        break;
                    default:
                        System.out.println("Erro no codigo! Digite novamente...");
                }

            }else{
                BANCO_NEGOCIO.adicionarContaCliente(clienteLogado);
                System.out.println("Olá " + clienteLogado.getNome());
                System.out.println("Conta criado com sucesso. Segue dados abaixo:");
                System.out.println(clienteLogado.toString());
            }

        }

    }

    public static void verificarUsuario(String cpf){
        Optional<Cliente> resultado = CLIENTE_NEGOCIO.consultarCliente(cpf);

        if(resultado.isPresent()){
            clienteLogado = resultado.get();
            System.out.println("Olá " + clienteLogado.getNome());
        }else{
            System.out.println("Erro CPF!!");
        }
    }
}
