package Strategy.problemas.CompressionStrategyProblem.BadSolution;

public class Loader {
    public static void main(String[] args) {
        ZipFile zipFile = new ZipFile();

        zipFile.ComprimirArquivo(TipoArquivo.IMAGEM);
        zipFile.ComprimirArquivo(TipoArquivo.PDF);
        zipFile.ComprimirArquivo(TipoArquivo.VIDEO);
    }
}
