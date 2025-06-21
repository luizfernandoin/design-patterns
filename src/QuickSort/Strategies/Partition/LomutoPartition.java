package QuickSort.Strategies.Partition;

import QuickSort.QuickSort;
import QuickSort.Strategies.Pivot.MiddlePivot;
import QuickSort.Strategies.Pivot.PivotStrategy;

import java.util.Arrays;


public class LomutoPartition implements PartitionStrategy {
    @Override
    public int partition(int[] arr, int left, int right, PivotStrategy pivotStrategy, QuickSort quickSort) {
        int pivotIndex = pivotStrategy.escolherPivot(arr, left, right);
        int pivotValue = arr[pivotIndex];
        int i = left;

        quickSort.notifyPartition(arr, left, right, pivotValue);
        quickSort.notifySwap(arr, left, pivotIndex);
        swap(arr, left, pivotIndex);

        for (int j = left + 1; j <= right; j++) {
            if (arr[j] <= pivotValue) {
                i++;
                quickSort.notifySwap(arr, i, j);
                swap(arr, i, j);
            }
        }

        quickSort.notifySwap(arr, left, i);
        swap(arr, left, i);

        return i;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
