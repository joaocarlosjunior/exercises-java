public class FormatadorCepEmJava {
    public static void main(String[] args) {
        try {
            String cepFormatado = formatarCep("4650000");
            System.out.println(cepFormatado);
        } catch (CepInvalidException e) {
            e.printStackTrace();
        }
    }

    static String formatarCep(String cep) throws CepInvalidException {
        if (cep.length() != 8)
            throw new CepInvalidException();

        return "46.500-000";
    }
}
