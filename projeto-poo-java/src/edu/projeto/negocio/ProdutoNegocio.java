package edu.projeto.negocio;

import edu.projeto.basedados.Banco;
import edu.projeto.entidade.Produto;

import java.util.List;
import java.util.Optional;

/**
 * Classe para manipular a entidade {@link Produto}.
 * @author João Carlos
 */
public class ProdutoNegocio {

    /**
     * {@inheritDoc}.
     */
    private Banco bancoDados;

    /**
     * Construtor.
     * @param banco Banco de dados para ter armazenar e ter acesso os produtos
     */
    public ProdutoNegocio(Banco banco) {
        this.bancoDados = banco;
    }

    /**
     * Salva um novo produto(livro ou caderno) na loja.
     * @param novoProduto Livro ou caderno que pode ser vendido
     */
    public void salvar(Produto novoProduto) {

        String codigo = "PR00";
        codigo = String.format(codigo, bancoDados.getProdutos().length);
        novoProduto.setCodigo(codigo);

        List<Produto> produtos = List.of(bancoDados.getProdutos());

        if (produtos.contains(novoProduto)){
            System.out.println("Produto já cadastrado.");
            System.out.println(produtos);
        }else{
            this.bancoDados.adicionarProduto(novoProduto);
            System.out.println("Produto cadastrado com sucesso.");
        }
    }

    /**
     * Exclui um produto pelo código de cadastro.
     * @param codigo Código de cadastro do produto
     */
    public void excluir(String codigo) {
        boolean produtoEncontrado = false;
        int i = 0;
        for (Produto produto: bancoDados.getProdutos()){
            if(produto.getCodigo().equalsIgnoreCase(codigo)){
                bancoDados.removerProduto(i);
                produtoEncontrado = true;
            }
            i++;
        }

        if(!produtoEncontrado){
            System.out.println("Produto não encontrado. Verifique se código está correto!");
        }else{
            System.out.println("Produto excluído com sucesso!!");
        }
    }

    /**
     * Obtem um produto a partir de seu código de cadastro.
     * @param codigo Código de cadastro do produto
     * @return Optional indicando a existência ou não do Produto
     */
    public Optional<Produto> consultar(String codigo) {
        for (Produto produto: bancoDados.getProdutos()) {
            if (produto.getCodigo().equalsIgnoreCase(codigo)) {
                return  Optional.of(produto);
            }
        }

        return Optional.empty();
    }

    /**
     * Lista todos os produtos cadastrados.
     */
    public void listarTodos() {

        if (bancoDados.getProdutos().length == 0) {
            System.out.println("Não existem produtos cadastrados");
        } else {

            for (Produto produto: bancoDados.getProdutos()) {
                System.out.println(produto.toString());
            }
        }
    }

}
