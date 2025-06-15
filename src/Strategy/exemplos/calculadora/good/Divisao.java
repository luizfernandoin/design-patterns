package Strategy.exemplos.calculadora.good;

public class Divisao implements Operacao{
    @Override
    public double calcular(double A, double B) {
        if (B == 0) throw new ArithmeticException("Divisão por zero!");

        return A / B;
    }
}
