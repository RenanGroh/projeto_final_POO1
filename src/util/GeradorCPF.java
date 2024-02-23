package util;

import java.util.Random;

public class GeradorCPF {

    public static String gerarCPF() {
        StringBuilder cpf = new StringBuilder();


        for (int i = 0; i < 9; i++) {
            cpf.append(new Random().nextInt(10));
        }


        int[] digitos = new int[11];
        int soma = 0;
        for (int i = 0; i < 9; i++) {
            digitos[i] = Character.getNumericValue(cpf.charAt(i)) * (i + 1);
            soma += digitos[i];
        }
        int digito1 = soma % 11 < 2 ? 0 : 11 - soma % 11;
        cpf.append(digito1);

        soma = 0;
        for (int i = 0; i < 10; i++) {
            digitos[i] = Character.getNumericValue(cpf.charAt(i)) * (i + 2);
            soma += digitos[i];
        }
        int digito2 = soma % 11 < 2 ? 0 : 11 - soma % 11;
        cpf.append(digito2);


        return String.format("%s.%s.%s-%s", cpf.substring(0, 3), cpf.substring(3, 6), cpf.substring(6, 9), cpf.substring(9));
    }
}

