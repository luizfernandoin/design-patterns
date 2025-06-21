package Visitor.problemas.Passagens.bad;

import java.time.LocalDate;

public class PassagemCrianca extends Passagem {
    private final LocalDate dataNascimento;

    public PassagemCrianca(double distancia, double valorPassagemPorKm, LocalDate dataNascimento) {
        super(distancia, valorPassagemPorKm);
        this.dataNascimento = dataNascimento;
    }

    @Override
    public double calcularPassagem() {
        LocalDate dataGratuidade = LocalDate.now().minusYears(10);
        if (this.dataNascimento.isAfter(dataGratuidade)) {
            // Possui algum desconto
            LocalDate dataMaia = LocalDate.now().minusYears(5);
            if (this.dataNascimento.isBefore(dataMaia)) {
                // 50%
                return (this.getDistancia() * this.getValorPassagemPorKm()) / 2;
            }

            return 0;
        }

        return this.getDistancia() * this.getValorPassagemPorKm();
    }
}
