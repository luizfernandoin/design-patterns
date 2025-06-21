package Strategy.problemas.PaymentStrategyProblem.GoodSolution;

import Strategy.problemas.PaymentStrategyProblem.GoodSolution.Strategy.Boleto;
import Strategy.problemas.PaymentStrategyProblem.GoodSolution.Strategy.Credito;
import Strategy.problemas.PaymentStrategyProblem.GoodSolution.Strategy.Pix;

public class Loader {
    public static void main(String[] args) {
        double valorCompra = 100.0;

        Pagamento pagamentoCartao = new Pagamento(new Credito());
        System.out.println("Cartão Credito: R$ " + pagamentoCartao.processarPagamento(valorCompra));

        Pagamento pagamentoBoleto = new Pagamento(new Boleto());
        System.out.println("Boleto: R$ " + pagamentoBoleto.processarPagamento(valorCompra));

        Pagamento pagamentoPix = new Pagamento(new Pix());
        System.out.println("PIX: R$ " + pagamentoPix.processarPagamento(valorCompra));
    }
}
