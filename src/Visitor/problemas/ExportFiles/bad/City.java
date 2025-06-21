package Visitor.problemas.ExportFiles.bad;

public class City implements Node {
    @Override
    public void exportar() {
        System.out.println("Exportando cidade para XML...");
    }
}
