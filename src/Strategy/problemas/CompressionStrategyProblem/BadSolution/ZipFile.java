package Strategy.problemas.CompressionStrategyProblem.BadSolution;

public class ZipFile {

    public void ComprimirArquivo(TipoArquivo tipoArquivo) {
        switch (tipoArquivo) {
            case PDF -> System.out.println("Comprimir pdf...");
            case IMAGEM -> System.out.println("Comprimir imagem...");
            case VIDEO -> System.out.println("Comprimir vídeo...");
        }
    }
}
