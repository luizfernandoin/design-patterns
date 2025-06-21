package Visitor.problemas.Passagens.bad;

public abstract class Passagem {
    private double distancia;
    private double valorPassagemPorKm;

    public Passagem(double distancia, double valorPassagemPorKm) {
        this.distancia = distancia;
        this.valorPassagemPorKm = valorPassagemPorKm;
    }

    public abstract double calcularPassagem();

    public double getDistancia() {
        return distancia;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

    public double getValorPassagemPorKm() {
        return valorPassagemPorKm;
    }

    public void setValorPassagemPorKm(double valorPassagemPorKm) {
        this.valorPassagemPorKm = valorPassagemPorKm;
    }
}
