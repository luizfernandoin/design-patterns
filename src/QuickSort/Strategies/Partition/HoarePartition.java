package QuickSort.Strategies.Partition;

import QuickSort.QuickSort;
import QuickSort.Strategies.Pivot.MiddlePivot;
import QuickSort.Strategies.Pivot.PivotStrategy;

import java.util.Arrays;

public class HoarePartition implements PartitionStrategy {
    @Override
    public int partition(int[] arr, int left, int right, PivotStrategy pivotStrategy, QuickSort quickSort) {
        int pivotIndex = pivotStrategy.escolherPivot(arr, left, right);
        int pivotValue = arr[pivotIndex];

        int i = left - 1;
        int j = right + 1;

        quickSort.notifyPartition(arr, left, right, pivotValue);

        while (true) {
            do {
                i++;
            } while (arr[i] < pivotValue);

            do {
                j--;
            } while (arr[j] > pivotValue);

            if (i >= j) return j;
            swap(arr, i, j);
            quickSort.notifySwap(arr, i, j);
        }
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
