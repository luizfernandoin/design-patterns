package Strategy.problemas.SortingStrategyProblem.BadSolution;

import java.util.List;


public class SortList {
    public void sort(List<?> valores) {
        if (valores.isEmpty()) {
            System.out.println("Lista vazia!");
            return;
        };

        Object firstValue = valores.getFirst();

        if (firstValue instanceof Integer) {
            // sorting with QuickSort
            this.QuickSortList(valores);
        } else if (firstValue instanceof String) {
            // sorting with BubbleSort
            this.BubbleSortList(valores);
        } else {
            // sorting with MergeSort
            this.MergeSortList(valores);
        }
    }

    private final void QuickSortList(List<?> list) {
        System.out.println("Ordenando o vetor " + list + " com QuickSort...");
    }

    private final void BubbleSortList(List<?> list) {
        System.out.println("Ordenando o vetor " + list + " com BubbleSort...");
    }

    private final void MergeSortList(List<?> list) {
        System.out.println("Ordenando o vetor " + list + " com MergeSort...");
    }
}
