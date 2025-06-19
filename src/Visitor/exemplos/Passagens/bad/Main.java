package Visitor.exemplos.Passagens.bad;

import Visitor.exemplos.Passagens.good.RedeEnsino;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Passagem passagemEstudante = new PassagemEstudante(100, 0.5, RedeEnsino.ESTADUAL);
        Passagem passagemCrianca = new PassagemCrianca(100, 0.5, LocalDate.of(2020, 02, 02));
        Passagem passagemIdoso = new PassagemIdoso(100, 0.5, LocalDate.of(1950, 02, 02));
        Passagem passagemComum = new PassagemComum(100, 0.5);

        System.out.println("O valor da passagem comum é: " + passagemComum.calcularPassagem());
        System.out.println("O valor da passagem estudante é: " + passagemEstudante.calcularPassagem());
        System.out.println("O valor da passagem criança é: " + passagemCrianca.calcularPassagem());
        System.out.println("O valor da passagem idoso é: " + passagemIdoso.calcularPassagem());
    }
}
