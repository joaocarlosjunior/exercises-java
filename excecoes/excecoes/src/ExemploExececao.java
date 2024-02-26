import java.text.NumberFormat;
import java.text.ParseException;

public class ExemploExececao {
    public static void main(String[] args) {
        Number value = Double.valueOf("a1.75");

        try {
            value = NumberFormat.getInstance().parse("a1.75");
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        System.out.println(value);
    }
}
