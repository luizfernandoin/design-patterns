package Strategy.problemas.PaymentStrategyProblem.GoodSolution.Strategy;

public class Debito implements PagamentoStrategy {
    @Override
    public double calcularValorFinal(double valor) {
        return valor;
    }
}
