package br.com.di0x1.request.converters;

public class NumberConverter {

    public static Double convertToDouble(String strnumber) throws IllegalArgumentException{
        if(strnumber == null || strnumber.isEmpty()) throw new UnsupportedOperationException("Please set a numeric value");
        String number = strnumber.replace("," , ".");
        return Double.parseDouble(number);
    }

    public static boolean isNumeric(String strnumber){
        if(strnumber == null || strnumber.isEmpty()) return false;
        String number = strnumber.replace("," , ".");
        return number.matches("[-+]?[0-9]*\\.?[0-9]+");
    }

    public static double raizQuadradaAproximada(double N) {
        double raizAproximadaInteira = Math.sqrt(N);
        double Q = raizAproximadaInteira * raizAproximadaInteira;

        if (Q == 0) {
            return 0;
        }
        double raiz_Q = Math.sqrt(Q);
        double aproximacao = (N + Q) / (2 * raiz_Q);

        return aproximacao;
    }
}
