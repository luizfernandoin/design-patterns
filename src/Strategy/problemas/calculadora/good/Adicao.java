package Strategy.problemas.calculadora.good;

public class Adicao implements Operacao{
    @Override
    public double calcular(double A, double B) {
        return A + B;
    }
}
