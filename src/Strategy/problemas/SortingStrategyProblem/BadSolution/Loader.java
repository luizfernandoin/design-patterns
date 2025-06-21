package Strategy.problemas.SortingStrategyProblem.BadSolution;

import java.util.List;

public class Loader {
    public static void main(String[] args) {
        SortList sortList = new SortList();

        List<Integer> listaInteger = List.of(3, 6, 4, 5, 1, 7, 2);
        List<String> listaString = List.of("Luiz", "Luiza", "Fernando", "Fernanda");

        sortList.sort(listaInteger);
        sortList.sort(listaString);
    }
}
