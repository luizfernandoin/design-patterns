package Strategy.problemas.PaymentStrategyProblem.GoodSolution.Strategy;

public class Pix implements PagamentoStrategy {
    @Override
    public double calcularValorFinal(double valor) {
        validarChavePix();
        return valor;
    }

    public void validarChavePix() {
        System.out.println("Validando chave pix...");
    }
}
