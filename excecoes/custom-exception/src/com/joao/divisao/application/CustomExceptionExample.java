package com.joao.divisao.application;

import com.joao.divisao.exceptions.NotExactDivisionException;

import java.lang.reflect.Array;
import java.rmi.NotBoundException;

public class CustomExceptionExample {

    public static void main(String[] args) {
        int[] numerator = {4, 5, 8, 10};
        int[] denominator = {2, 4, 0, 2, 8};

        for (int i = 0; i < denominator.length; i++) {

            try {
                if (numerator[i] % 2 != 0)
                    throw new NotExactDivisionException("Divisão Não Exata.", numerator[i], denominator[i]);

                int result = numerator[i] / denominator[i];
                System.out.println("O resultado da divisão de " +
                        numerator[i] + " por " + denominator[i] +
                        " é " + result
                );
            }catch (NotExactDivisionException e) {
                System.out.println("{" + e.getMessage());
                System.out.println("{" + e);
            }catch (ArithmeticException e){
                System.out.println("Divsão por zero");
            }catch (ArrayIndexOutOfBoundsException e){
                System.out.println("Um array maior que o outro.");
            }
        }
    }
}
