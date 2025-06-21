package QuickSort.Strategies.Partition;

import QuickSort.QuickSort;
import QuickSort.Strategies.Pivot.PivotStrategy;

public interface PartitionStrategy {
    int partition(int[] arr, int left, int right, PivotStrategy pivotStrategy, QuickSort quickSort);
}
