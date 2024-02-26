import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class AboutMe {
    public static void main(String[] args) throws Exception {

        try {
            Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

            System.out.println("Digite seu nomer:");
            String name = scanner.next();

            System.out.println("Digite seu sobrenome:");
            String lastName = scanner.next();

            System.out.println("Digite sua idade:");
            int age = scanner.nextInt();

            System.out.println("Digite seu altura:");
            double height = scanner.nextDouble();

            System.out.println("Ola, me chamo " + name.toUpperCase() + " " + lastName.toUpperCase());
            System.out.println("Tenho " + age + "anos");
            System.out.println("Minha altura é" + height + "cm");

            scanner.close();
        } catch (InputMismatchException e) {
            // TODO: handle exception
            System.out.println("Idade e altura precisam ser númericos!!");
        }
    }
}
