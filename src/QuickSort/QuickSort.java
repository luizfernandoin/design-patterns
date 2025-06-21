package QuickSort;

import QuickSort.Strategies.Observers.QuickSortObserver;
import QuickSort.Strategies.Partition.HoarePartition;
import QuickSort.Strategies.Partition.LomutoPartition;
import QuickSort.Strategies.Partition.PartitionStrategy;
import QuickSort.Strategies.Pivot.PivotStrategy;

import java.util.ArrayList;
import java.util.List;

public class QuickSort {
    PivotStrategy pivotStrategy;
    PartitionStrategy partitionStrategy;
    private final List<QuickSortObserver> observers = new ArrayList<>();

    public QuickSort(PivotStrategy pivotStrategy, PartitionStrategy partitionStrategy) {
        this.pivotStrategy = pivotStrategy;
        this.partitionStrategy = partitionStrategy;
    }

    public void addObserver(QuickSortObserver observer) {
        this.observers.add(observer);
    }

    public int[] sort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return arr;
        }

        quickSort(arr, 0, arr.length - 1);
        return arr;
    }

    private void quickSort(int[] arr, int left, int right) {
        notifyRecursion(left, right);

        if (left < right) {
            int pivotIndex = partitionStrategy.partition(arr, left, right, pivotStrategy, this);

            if (partitionStrategy instanceof HoarePartition) {
                quickSort(arr, left, pivotIndex);
                quickSort(arr, pivotIndex + 1, right);
            } else if (partitionStrategy instanceof LomutoPartition) {
                quickSort(arr, left, pivotIndex - 1);
                quickSort(arr, pivotIndex + 1, right);
            }
        }
    }

    public void notifySwap(int[] arr, int i, int j) {
        for (QuickSortObserver observer : observers) {
            observer.onSwap(arr, i, j);
        }
    }

    public void notifyPartition(int[] arr, int left, int right, int pivot) {
        for (QuickSortObserver observer : observers) {
            observer.onPartition(arr, left, right, pivot);
        }
    }

    public void notifyRecursion(int left, int right) {
        for (QuickSortObserver observer : observers) {
            observer.onRecursion(left, right);
        }
    }

    public void setPartitionStrategy(PartitionStrategy partitionStrategy) {
        this.partitionStrategy = partitionStrategy;
    }

    public void setPivotStrategy(PivotStrategy pivotStrategy) {
        this.pivotStrategy = pivotStrategy;
    }
}
