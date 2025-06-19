package Visitor.exemplos.Passagens.bad;

import Visitor.exemplos.Passagens.good.RedeEnsino;

public class PassagemEstudante extends Passagem {
    RedeEnsino redeEnsino;

    public PassagemEstudante(double distancia, double valorPassagemPorKm, RedeEnsino redeEnsino) {
        super(distancia, valorPassagemPorKm);
        this.redeEnsino = redeEnsino;
    }

    @Override
    public double calcularPassagem() {
        double desconto = 0;

        switch (this.redeEnsino) {
            case MUNICIPAL -> desconto = 0.30;
            case ESTADUAL -> desconto = 0.25;
            case FEDERAL -> desconto = 0.35;
        }

        return (this.getDistancia() * this.getValorPassagemPorKm()) * (1d - desconto);
    }
}
