package Strategy.exemplos.calculadora.good;


public class Main {
    public static void main(String[] args) {
        Calculadora calc = new Calculadora(new Adicao());

        double soma = calc.calcular(8, 2);
        System.out.println(soma);

        calc.setOperacao(new Subtracao());
        double subtracao = calc.calcular(8, 2);
        System.out.println(subtracao);

        calc.setOperacao(new Multiplicacao());
        double multiplicacao = calc.calcular(8, 2);
        System.out.println(multiplicacao);

        calc.setOperacao(new Divisao());
        double divisao = calc.calcular(8, 2);
        System.out.println(divisao);
    }
}