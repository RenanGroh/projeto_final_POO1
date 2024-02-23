package util;

public class ValidadorCPF {

    // TESTE
//    public static void main(String[] args) {
//        String cpfValido = "12345678909"; // Substitua por um CPF válido
//        String cpfInvalido = "11111111111"; // CPF com dígitos repetidos (inválido)
//
//        System.out.println("CPF válido (" + cpfValido + "): " + validarCPF(cpfValido));
//        System.out.println("CPF inválido (" + cpfInvalido + "): " + validarCPF(cpfInvalido));
//    }

    public static boolean validarCPF(String cpf) {
        cpf = cpf.replaceAll("\\D", ""); // Remove caracteres não numéricos

        if (cpf.length() != 11 || temDigitosIguais(cpf)) {
            return false;
        }

        int d1 = calcularDigito(cpf.substring(0, 9), new int[]{10, 9, 8, 7, 6, 5, 4, 3, 2});
        int d2 = calcularDigito(cpf.substring(0, 9) + d1, new int[]{11, 10, 9, 8, 7, 6, 5, 4, 3, 2});

        return cpf.equals(cpf.substring(0, 9) + d1 + d2);
    }

    private static int calcularDigito(String str, int[] pesos) {
        int soma = 0;
        for (int indice = str.length() - 1, digito; indice >= 0; indice--) {
            digito = Integer.parseInt(str.substring(indice, indice + 1));
            soma += digito * pesos[pesos.length - str.length() + indice];
        }
        soma = 11 - soma % 11;
        return soma > 9 ? 0 : soma;
    }

    private static boolean temDigitosIguais(String cpf) {
        for (int i = 1; i < cpf.length(); i++) {
            if (cpf.charAt(i) != cpf.charAt(0)) {
                return false;
            }
        }
        return true;
    }
}
