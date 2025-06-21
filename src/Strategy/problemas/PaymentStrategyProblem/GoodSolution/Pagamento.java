package Strategy.problemas.PaymentStrategyProblem.GoodSolution;

import Strategy.problemas.PaymentStrategyProblem.GoodSolution.Strategy.PagamentoStrategy;

public class Pagamento {
    PagamentoStrategy pagamentoStrategy;

    public Pagamento(PagamentoStrategy pagamentoStrategy) {
        this.pagamentoStrategy = pagamentoStrategy;
    }

    public double processarPagamento(double valor) {
        return pagamentoStrategy.calcularValorFinal(valor);
    }
}
