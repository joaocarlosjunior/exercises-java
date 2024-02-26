package org.excecoes.example.bank.application;

import com.sun.source.tree.NewArrayTree;
import org.excecoes.example.bank.entities.Account;
import org.excecoes.example.bank.exceptions.BusinessExcepetion;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("--Informe os dados da conta--");
        System.out.print("Numero: ");
        Integer numberAccount = scanner.nextInt();
        System.out.print("Titular: ");
        scanner.nextLine();
        String name = scanner.nextLine();
        System.out.print("Saldo Inicial: ");
        Double balance = scanner.nextDouble();
        System.out.print("Limite de Saque: ");
        Double withdrawLimit = scanner.nextDouble();

        Account acc = new Account(numberAccount,name,balance,withdrawLimit);

        System.out.print("Informe uma quantia para sacar: ");
        Double amount =  scanner.nextDouble();

        try{
            acc.withdraw(amount);
            System.out.printf("Novo saldo: %.2f%n", acc.getBalance());
        }catch (BusinessExcepetion e){
            System.out.println(e.getMessage());
        }

        scanner.close();
    }
}
