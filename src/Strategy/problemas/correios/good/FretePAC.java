package Strategy.problemas.correios.good;

public class FretePAC implements FreteStrategy {
    @Override
    public double calcularFrete(double peso) {
        return 10 + peso * 1.5;
    }
}
