package Strategy.problemas.PaymentStrategyProblem.GoodSolution.Strategy;

public class Boleto implements PagamentoStrategy {
    @Override
    public double calcularValorFinal(double valor) {
        return  valor - (valor * 0.05);
    }
}
