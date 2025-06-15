package Strategy.exemplos.calculadora.bad;

public class Calculadora {
    public double calcular(double A, double B, char operacao) {
        switch (operacao) {
            case '+':
                return A + B;
            case '-':
                return A - B;
            case '*':
                return A * B;
            case '/':
                return A / B;
            default:
                throw new IllegalArgumentException("Operação desconhecida: " + operacao);
        }
    };
}
