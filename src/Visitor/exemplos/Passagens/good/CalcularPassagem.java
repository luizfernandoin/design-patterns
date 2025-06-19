package Visitor.exemplos.Passagens.good;


import java.time.LocalDate;

public class CalcularPassagem implements Visitor {
    Double valorPassagemPorKm;

    public CalcularPassagem(Double valorPassagemPorKm) {
        this.valorPassagemPorKm = valorPassagemPorKm;
    }

    @Override
    public double visitar(PassagemEstudante passagemEstudante) {
        double desconto = 0;

        switch (passagemEstudante.getRedeEnsino()) {
            case MUNICIPAL -> desconto = 0.30;
            case ESTADUAL -> desconto = 0.25;
            case FEDERAL -> desconto = 0.35;
        }

        return (passagemEstudante.getDistancia() * valorPassagemPorKm) * (1d - desconto);
    }

    @Override
    public double visitar(PassagemComum passagemComum) {
        return passagemComum.getDistancia() * valorPassagemPorKm;
    }

    @Override
    public double visitar(PassagemIdoso passagemIdoso) {
        LocalDate dataDesconto = LocalDate.now().minusYears(60);

        if (passagemIdoso.getDataNascimento().isBefore(dataDesconto)) {
            return (passagemIdoso.getDistancia() * valorPassagemPorKm) / 2;
        }

        return (passagemIdoso.getDistancia() * valorPassagemPorKm);
    }

    @Override
    public double visitar(PassagemCrianca passagemCrianca) {
        LocalDate dataGratuidade = LocalDate.now().minusYears(10);
        if (passagemCrianca.getDataNascimento().isAfter(dataGratuidade)) {
            // Possui algum desconto
            LocalDate dataMaia = LocalDate.now().minusYears(5);
            if (passagemCrianca.getDataNascimento().isBefore(dataMaia)) {
                // 50%
                return (passagemCrianca.getDistancia() * valorPassagemPorKm) / 2;
            }

            return 0;
        }

        return passagemCrianca.getDistancia() * valorPassagemPorKm;
    }
}
