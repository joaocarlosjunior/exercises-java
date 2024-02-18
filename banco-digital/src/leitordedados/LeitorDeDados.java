package leitordedados;

import entidade.Cliente;
import java.util.Scanner;

public abstract class LeitorDeDados {

    public static String lerDados(){
        Scanner scanner = new Scanner(System.in);

        return scanner.next();
    }

    public static Double lerValor(){
        System.out.println("Digite valor: ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextDouble();
    }

    public static Cliente lerCliente(){
        Cliente cliente = new Cliente();

        System.out.println("Digite nome:");
        cliente.setNome(lerDados());
        System.out.println("Digite CPF:");
        String cpf = lerDados();
        cliente.setCpf(cpf);

        return cliente;
    }

}
