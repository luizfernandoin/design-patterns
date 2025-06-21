package Visitor.problemas.Passagens.good;

import java.time.LocalDate;

public class PassagemIdoso implements Passagem {
    private double distancia;
    private LocalDate dataNascimento;

    public PassagemIdoso(double distancia, LocalDate dataNascimento) {
        this.distancia = distancia;
        this.dataNascimento = dataNascimento;
    }

    @Override
    public double accept(Visitor visitor) {
        return visitor.visitar(this);
    }

    public double getDistancia() {
        return distancia;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
}
