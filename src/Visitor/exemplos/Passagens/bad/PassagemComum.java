package Visitor.exemplos.Passagens.bad;

public class PassagemComum extends Passagem {
    public PassagemComum(double distancia, double valorPassagemPorKm) {
        super(distancia, valorPassagemPorKm);
    }

    @Override
    public double calcularPassagem() {
        return this.getDistancia() * this.getValorPassagemPorKm();
    }
}
