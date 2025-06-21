package Strategy.problemas.correios.good;

public class CalculadoraFrete {
    private FreteStrategy freteStrategy;

    public CalculadoraFrete(FreteStrategy freteStrategy) {
        this.freteStrategy = freteStrategy;
    }

    public void setFreteStrategy(FreteStrategy freteStrategy) {
        this.freteStrategy = freteStrategy;
    }

    public double calcular(double peso) {
        return freteStrategy.calcularFrete(peso);
    }
}
