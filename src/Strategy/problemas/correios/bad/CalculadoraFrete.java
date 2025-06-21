package Strategy.problemas.correios.bad;

public class CalculadoraFrete {
    public double calcularFrete(String tipoFrete, double peso) {
        if (tipoFrete.equalsIgnoreCase("SEDEX")) {
            return 20 + peso * 2;
        } else if (tipoFrete.equalsIgnoreCase("PAC")) {
            return 10 + peso * 1.5;
        } else if (tipoFrete.equalsIgnoreCase("RETIRADA")) {
            return 0;
        } else {
            throw new IllegalArgumentException("Tipo de frete inválido: " + tipoFrete);
        }
    }
}
