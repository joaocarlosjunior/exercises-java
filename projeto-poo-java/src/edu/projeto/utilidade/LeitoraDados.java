package edu.projeto.utilidade;

import edu.projeto.entidade.*;
import edu.projeto.entidade.constantes.Genero;
import edu.projeto.entidade.constantes.Materias;
import edu.projeto.basedados.Banco;
import one.digitalinovation.laboojava.entidade.*;
import edu.projeto.negocio.ProdutoNegocio;

import java.util.Optional;
import java.util.Scanner;

/**
 * Classe utilitária para auxiliar na leitura de entradas de dados via teclado.
 *
 * @author João Carlos
 */
public final class LeitoraDados {

    /**
     * Classe do Java para manipular entradas via teclado.
     */
    private static Scanner scanner;

    static {
        scanner = new Scanner(System.in);
    }

    /**
     * Ler um dado específico
     *
     * @return Dado lido
     */
    public static String lerDado() {
        String texto = scanner.nextLine();
        return texto;
    }

    /**
     * Ler os dados do livro a ser cadastrado.
     *
     * @return Um livro a partir dos dados de entrada
     */
    public static Livro lerLivro() {

        System.out.println("Cadastrando livro...");
        Livro livro = new Livro();

        System.out.println("Digite o nome:");
        String nome = lerDado();
        livro.setNome(nome);

        boolean estaCorreto = false;
        do {
            System.out.println("Digite o gênero: DRAMA, SUSPENSE, ROMANCE");
            String genero = lerDado();
            if (genero.equalsIgnoreCase("DRAMA") || genero.equalsIgnoreCase("SUSPENSE") || genero.equalsIgnoreCase("ROMANCE")) {
                estaCorreto = true;
                livro.setGenero(Genero.valueOf(genero.toUpperCase()));
            } else {
                System.out.println("ERRO!! INFORME CORRETAMENTE O GÊNERO");
            }
        } while (!estaCorreto);

        System.out.println("Digite o preço(padrão 0.0):");
        String preco = lerDado();
        livro.setPreco(Double.parseDouble(preco));

        return livro;
    }

    /**
     * Ler os dados do caderno a ser cadastrado.
     *
     * @return Um caderno a partir dos dados de entrada
     */
    //TODO Método para ler o caderno
    public static Caderno lerCaderno() {
        Caderno caderno = new Caderno();

        System.out.println("Cadastrando Caderno...");

        boolean estaCorreto = false;
        do {
            System.out.println("Digite o tipo do caderno M2, M5 ou M10:");
            String tipo = lerDado();
            if (tipo.equalsIgnoreCase("M2") || tipo.equalsIgnoreCase("M5") || tipo.equalsIgnoreCase("M10")) {
                estaCorreto = true;
                caderno.setMateria(Materias.valueOf(tipo.toUpperCase()));
            } else {
                System.out.println("ERRO!! INFORME CORRETAMENTE O GÊNERO");
            }
        } while (!estaCorreto);

        System.out.println("Digite o preço(padrão 0.0):");
        String preco = lerDado();
        caderno.setPreco(Double.parseDouble(preco));

        return caderno;
    }

    /**
     * Ler os dados do pedido e retorna um objeto a partir destes.
     *
     * @return Um pedido a partir dos dados de entrada
     */
    public static Pedido lerPedido(Banco banco) {

        ProdutoNegocio produtoNegocio = new ProdutoNegocio(banco);

        System.out.println("Cadastrando pedido...");
        Pedido pedido = new Pedido();

        String opcao = "s";
        do {

            System.out.println("Digite o código do produto(livro/Caderno)");
            String codigo = lerDado();

            Optional<Produto> resultado = produtoNegocio.consultar(codigo);
            if (resultado.isPresent()) {

                Produto produto = resultado.get();

                System.out.println("Digite a quantidade:");
                String quantidade = lerDado();
                produto.setQuantidade(Integer.parseInt(quantidade));

                pedido.setProdutos(produto);
            } else {
                System.out.println("Produto inexistente. Escolha um produto válido");
            }

            System.out.println("Deseja selecionar mais um produto? s/n");
            opcao = lerDado();
        } while ("s".equalsIgnoreCase(opcao));

        return pedido;
    }

    /**
     * Ler os dados do cupom e retorna um objeto a partir destes.
     *
     * @return O cupom a partir dos dados de entrada
     */
    public static Optional<Cupom> lerCupom(Banco banco) {

        System.out.println("Caso queira utilizar algum cupom escolha entre: CUPOM2, CUPOM5, CUPOM7. Se não desejar, deixe em branco.");

        String desconto = lerDado();

        for (Cupom cupom : banco.getCupons()) {
            if (cupom.getCodigo().equalsIgnoreCase(desconto)) {
                return Optional.of(cupom);
            }
        }

        return Optional.empty();
    }

    public static Cliente lerCliente() {
        Cliente cliente = new Cliente();

        System.out.println("Cadastrando cliente...");

        System.out.println("Informa nome:");
        String nome = lerDado();
        cliente.setNome(nome);

        System.out.println("Informe CPF:");
        String cpf = lerDado();
        cliente.setCpf(cpf);

        return cliente;
    }

}
