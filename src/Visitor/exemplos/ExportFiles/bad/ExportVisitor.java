package Visitor.exemplos.ExportFiles.bad;


public class ExportVisitor implements Visitor {
    @Override
    public void visitCity(City city) {
        System.out.println("Exportando cidade para XML...");
    }

    @Override
    public void visitIndustry(Industry industry) {
        System.out.println("Exportando industria para XML...");
    }
}
