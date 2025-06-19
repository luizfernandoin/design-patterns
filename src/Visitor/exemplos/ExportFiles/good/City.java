package Visitor.exemplos.ExportFiles.good;

public class City implements Element {

    @Override
    public void accept(Visitor visitor) {
        visitor.visitCity(this);
    }
}
