package Strategy.exemplos.correios.good;

public class FreteRetiradaLoja implements FreteStrategy {
    @Override
    public double calcularFrete(double peso) {
        return 0;
    }
}
