package Strategy.problemas.PaymentStrategyProblem.GoodSolution.Strategy;

public class Credito implements PagamentoStrategy {
    @Override
    public double calcularValorFinal(double valor) {
        return valor + (valor * 0.03);
    }
}
