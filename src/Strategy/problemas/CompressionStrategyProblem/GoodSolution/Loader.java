package Strategy.problemas.CompressionStrategyProblem.GoodSolution;


import Strategy.problemas.CompressionStrategyProblem.GoodSolution.Strategy.ZipImagem;
import Strategy.problemas.CompressionStrategyProblem.GoodSolution.Strategy.ZipPDF;
import Strategy.problemas.CompressionStrategyProblem.GoodSolution.Strategy.ZipStrategy;
import Strategy.problemas.CompressionStrategyProblem.GoodSolution.Strategy.ZipVideo;

import java.util.List;

public class Loader {
    public static void main(String[] args) {
        List<ZipStrategy> zipStrategies = List.of(
                new ZipImagem(),
                new ZipPDF(),
                new ZipVideo()
        );

        ZipFile zipFile = new ZipFile(new ZipImagem());

        for (ZipStrategy zipStrategy : zipStrategies) {
            zipFile.setZipStrategy(zipStrategy);
            zipFile.comprimirArquivo();
        }
    }
}
