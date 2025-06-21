package Visitor.problemas.Passagens.good;

public class PassagemComum implements Passagem {
    double distancia;

    public PassagemComum(double distancia) {
        this.distancia = distancia;
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
}
