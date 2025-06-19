package Visitor.exemplos.Passagens.good;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Visitor calcularPassagem = new CalcularPassagem(0.5);

        Passagem passagemEstudante = new PassagemEstudante(RedeEnsino.ESTADUAL, 100);
        Passagem passagemCrianca = new PassagemCrianca(100, LocalDate.of(2020, 02, 02));
        Passagem passagemIdoso = new PassagemIdoso(100, LocalDate.of(1950, 02, 02));
        Passagem passagemComum = new PassagemComum(100);

        System.out.println("O valor da passagem comum é: " + passagemComum.accept(calcularPassagem));
        System.out.println("O valor da passagem estudante é: " + passagemEstudante.accept(calcularPassagem));
        System.out.println("O valor da passagem criança é: " + passagemCrianca.accept(calcularPassagem));
        System.out.println("O valor da passagem idoso é: " + passagemIdoso.accept(calcularPassagem));
    }
}
