package Visitor.exemplos.ExportFiles.good;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Element> graph = List.of(
                new City(),
                new Industry(),
                new City()
        );

        ExportToXMLVisitor exportToXMLVisitor = new ExportToXMLVisitor();

        for (Element e : graph) {
            e.accept(exportToXMLVisitor);
        }
    }
}
