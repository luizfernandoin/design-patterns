package Visitor.problemas.ExportFiles.good;

public class City implements Element {

    @Override
    public void accept(Visitor visitor) {
        visitor.visitCity(this);
    }
}
