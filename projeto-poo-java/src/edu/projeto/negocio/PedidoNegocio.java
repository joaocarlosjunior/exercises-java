package edu.projeto.negocio;

import edu.projeto.basedados.Banco;
import edu.projeto.entidade.Cliente;
import edu.projeto.entidade.Cupom;
import edu.projeto.entidade.Pedido;
import edu.projeto.entidade.Produto;
import one.digitalinovation.laboojava.entidade.*;

import java.time.Instant;
import java.util.List;

/**
 * Classe para manipular a entidade {@link Pedido}.
 *
 * @author João Carlos
 */
public class PedidoNegocio {

    /**
     * {@inheritDoc}.
     */
    private Banco bancoDados;

    /**
     * Construtor.
     *
     * @param banco Banco de dados para ter armazenar e ter acesso os pedidos
     */
    public PedidoNegocio(Banco banco) {
        this.bancoDados = banco;
    }

    private double calcularTotal(List<Produto> produtos, Cupom cupom) {

        double total = 0.0;
        for (Produto produto : produtos) {
            total += produto.calcularFrete();
        }

        if (cupom != null) {
            return total * (1 - cupom.getDesconto());
        } else {
            return total;
        }

    }

    /**
     * Salva um novo pedido sem cupom de desconto.
     *
     * @param novoPedido Pedido a ser armazenado
     */
    public void salvar(Pedido novoPedido, Cliente cliente) {
        salvar(novoPedido, null, cliente);
    }

    /**
     * Salva um novo pedido com cupom de desconto.
     *
     * @param novoPedido Pedido a ser armazenado
     * @param cupom      Cupom de desconto a ser utilizado
     */
    public void salvar(Pedido novoPedido, Cupom cupom, Cliente cliente) {

        String codigoPedido = "PR%06d";
        Instant instant = Instant.now();
        long timeStampMillis = instant.toEpochMilli();
        codigoPedido = String.format(codigoPedido, timeStampMillis);


        novoPedido.setCodigo(codigoPedido);
        novoPedido.setCliente(cliente);
        double total = calcularTotal(novoPedido.getProdutos(),null);
        novoPedido.setValorTotal(total);
        bancoDados.adicionarPedido(novoPedido);
        System.out.println("Pedido finalizado com sucesso!!");
        //Setar código no pedido
        //Setar cliente no pedido
        //Calcular e set total
        //Adicionar no banco
        //Mensagem
    }

    /**
     * Exclui um pedido a partir de seu código de rastreio.
     *
     * @param codigo Código do pedido
     */
    public void excluir(String codigo) {

        int pedidoExclusao = -1;
        for (int i = 0; i < bancoDados.getPedidos().length; i++) {

            Pedido pedido = bancoDados.getPedidos()[i];
            if (pedido.getCodigo().equals(codigo)) {
                pedidoExclusao = i;
                break;
            }
        }

        if (pedidoExclusao != -1) {
            bancoDados.removerPedido(pedidoExclusao);
            System.out.println("Pedido excluído com sucesso.");
        } else {
            System.out.println("Pedido inexistente.");
        }
    }

    /**
     * Lista todos os pedidos realizados.
     */
    //TODO Método de listar todos os pedidos

    public void listarPedidos(){

        for (Pedido pedido: bancoDados.getPedidos()){
            System.out.println("Codigo" + pedido.getCodigo());
            System.out.println("Cliente: " + pedido.getCliente().getNome());
            System.out.println("Total: " + pedido.getValorTotal());
        }
    }

    public void consultar(String codigoPedido){
        boolean pedidoEncontrado = false;
        for (Pedido pedido: bancoDados.getPedidos()){
            if(pedido.getCodigo().equalsIgnoreCase(codigoPedido)){
                pedidoEncontrado = true;
                System.out.println("Codigo: " + pedido.getCodigo());
                System.out.println("Cliente: " + pedido.getCliente());
                System.out.println("Lista de produto(s):");
                for (Produto produto: pedido.getProdutos()){
                    System.out.println(produto.toString());
                }
                System.out.println("Valor Total: " + pedido.getValorTotal());
            }
        }

        if(!pedidoEncontrado){
            System.out.println("Erro! Código inválido...");
        }

    }
}