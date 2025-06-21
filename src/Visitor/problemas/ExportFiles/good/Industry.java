package Visitor.problemas.ExportFiles.good;

public class Industry implements Element {
    @Override
    public void accept(Visitor visitor) {
        visitor.visitIndustry(this);
    }
}
