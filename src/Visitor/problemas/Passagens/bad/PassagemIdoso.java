package Visitor.problemas.Passagens.bad;

import java.time.LocalDate;

public class PassagemIdoso extends Passagem {
    LocalDate dataNascimento;

    public PassagemIdoso(double distancia, double valorPassagemPorKm, LocalDate dataNascimento) {
        super(distancia, valorPassagemPorKm);
        this.dataNascimento = dataNascimento;
    }

    @Override
    public double calcularPassagem() {
        LocalDate dataDesconto = LocalDate.now().minusYears(60);

        if (this.dataNascimento.isBefore(dataDesconto)) {
            return (this.getDistancia() * this.getValorPassagemPorKm()) / 2;
        }

        return (this.getDistancia() * this.getValorPassagemPorKm());
    }
}
