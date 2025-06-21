package Strategy.problemas.correios.good;

public class FreteSedex implements FreteStrategy {
    @Override
    public double calcularFrete(double peso) {
        return 20 + peso * 2;
    }
}
