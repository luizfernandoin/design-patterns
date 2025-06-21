package Visitor.problemas.ExportFiles.bad;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Node> graph = List.of(
            new City(),
            new Industry(),
            new City()
        );

        ExportVisitor exportVisitor = new ExportVisitor();

        for (Node node : graph) {
            if (node instanceof City) {
                exportVisitor.visitCity((City) node);
            } else if (node instanceof Industry) {
                exportVisitor.visitIndustry((Industry) node);
            }
        }
    }
}
