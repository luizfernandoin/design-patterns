package SOLID.lsp.good;

public class Retangulo implements Forma {
    protected double largura;
    protected double altura;

    public Retangulo(double largura, double altura) {
        this.largura = largura;
        this.altura = altura;
    }

    public double CalcularArea() {
        return largura * altura;
    }
}
