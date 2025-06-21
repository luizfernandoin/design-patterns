package Strategy.problemas.calculadora.good;

public class Calculadora {
    private Operacao operacao;

    public Calculadora(Operacao operacao) {
        this.operacao = operacao;
    }

    public void setOperacao(Operacao operacao) {
        this.operacao = operacao;
    }

    public double calcular(double A, double B) {
        return operacao.calcular(A, B);
    }
}
