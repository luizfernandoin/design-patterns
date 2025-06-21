package Strategy.problemas.calculadora.good;

public class Multiplicacao implements Operacao {
    @Override
    public double calcular(double A, double B) {
        return A * B;
    }
}
