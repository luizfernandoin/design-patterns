package Strategy.problemas.CompressionStrategyProblem.GoodSolution;

import Strategy.problemas.CompressionStrategyProblem.GoodSolution.Strategy.ZipStrategy;

public class ZipFile {
    private ZipStrategy zipStrategy;

    public ZipFile(ZipStrategy zipStrategy) {
        this.zipStrategy = zipStrategy;
    }

    public void comprimirArquivo() {
        zipStrategy.comprimir();
    }

    public void setZipStrategy(ZipStrategy zipStrategy) {
        this.zipStrategy = zipStrategy;
    }
}
