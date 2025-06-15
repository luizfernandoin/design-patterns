package Strategy.exemplos.calculadora.bad;

public class Main {
    public static void main(String[] args) {
        Calculadora calc = new Calculadora();
        double soma = calc.calcular(8, 2, '+');
        System.out.println(soma);
    }
}
