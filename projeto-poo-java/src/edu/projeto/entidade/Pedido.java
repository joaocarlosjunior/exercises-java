package edu.projeto.entidade;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe que representa a entidade pedido, qual é a compra dos produtos por um cliente.
 * @author João Carlos
 */
public class Pedido {

    //TODO Preencher esta classe

    private String codigo;
    private Cliente cliente;

    private List<Produto> produtos;

    private double valorTotal;

    public Pedido(){
        this.produtos = new ArrayList<>();
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setProdutos(Produto produto) {
        produtos.add(produto);
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public String getCodigo() {
        return codigo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    //codigo
    //cliente
    //produtos
    //total
}
