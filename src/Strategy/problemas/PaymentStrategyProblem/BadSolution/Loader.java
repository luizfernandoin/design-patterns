package Strategy.problemas.PaymentStrategyProblem.BadSolution;

public class Loader {
    public static void main(String[] args) {
        Pagamento pagamento = new Pagamento(100);

        pagamento.realizarPagamento(FormaPagamento.BOLETO);
        pagamento.realizarPagamento(FormaPagamento.CREDITO);
        pagamento.realizarPagamento(FormaPagamento.PIX);
    }
}
