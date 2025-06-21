package Strategy.problemas.PaymentStrategyProblem.BadSolution;

public class Pagamento {
    private double valor;
    private FormaPagamento formaPagamento;

    public Pagamento(double valor) {
        this.valor = valor;
    }

    public void realizarPagamento(FormaPagamento formaPagamento) {
        this.formaPagamento = formaPagamento;
        System.out.println(calcularValorPagamento());
    }

    private final double calcularValorPagamento() {
        switch (formaPagamento) {
            case PIX -> {
                return this.calcularPagamentoPix();
            }
            case BOLETO -> {
                return this.calcularPagamentoBoleto();
            }
            case CREDITO -> {
                return this.calcularPagamentoCredito();
            }
        }
        return 0;
    }

    private final double calcularPagamentoCredito() {
        return this.valor + (valor * 0.03);
    }

    private final double calcularPagamentoBoleto() {
        double desconto = this.valor * 0.05;
        return  this.valor - desconto;
    }

    private final double calcularPagamentoPix() {
        validarChavePix();
        return this.valor;
    }

    private final void validarChavePix() {
        System.out.println("Validando chave pix...");
    }
}
