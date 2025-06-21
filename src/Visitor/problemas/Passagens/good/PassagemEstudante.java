package Visitor.problemas.Passagens.good;

public class PassagemEstudante implements Passagem {
    private RedeEnsino redeEnsino;
    private double distancia;

    public PassagemEstudante(RedeEnsino redeEnsino, double distancia) {
        this.redeEnsino = redeEnsino;
        this.distancia = distancia;
    }

    @Override
    public double accept(Visitor visitor) {
        return visitor.visitar(this);
    }

    public RedeEnsino getRedeEnsino() {
        return redeEnsino;
    }

    public void setRedeEnsino(RedeEnsino redeEnsino) {
        this.redeEnsino = redeEnsino;
    }

    public double getDistancia() {
        return distancia;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }
}
