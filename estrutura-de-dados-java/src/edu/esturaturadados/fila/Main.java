package edu.esturaturadados.fila;

public class Main {

    public static void main(String[] args) {
        Fila<String> minhaFila = new Fila<>();

        minhaFila.enqueue("Primeiro");
        minhaFila.enqueue("Segundo");
        minhaFila.enqueue("Terceiro");
        minhaFila.enqueue("Quarto");
        minhaFila.enqueue("Quinto");

        System.out.println(minhaFila);

        System.out.println("Retirado: " + minhaFila.dequeue());

        System.out.println(minhaFila);

        System.out.println("Primeiro da fila: " + minhaFila.first());

    }
}
