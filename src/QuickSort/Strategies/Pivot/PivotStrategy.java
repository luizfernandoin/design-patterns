package QuickSort.Strategies.Pivot;

import java.util.List;

public interface PivotStrategy {
    int escolherPivot(int[] arr, int left, int right);
}
