package QuickSort;

import QuickSort.Strategies.Observers.ConsoleObserver;
import QuickSort.Strategies.Partition.HoarePartition;
import QuickSort.Strategies.Partition.LomutoPartition;
import QuickSort.Strategies.Pivot.MiddlePivot;
import QuickSort.Strategies.Pivot.PivotStrategy;
import QuickSort.Strategies.Pivot.RangePivot;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int[] arr = {3, 6, 4, 5, 1, 7, 2};
        int[] arr1 = {3, 6, 4, 5, 1, 7, 2};
        int left = 0;
        int right = arr.length - 1;

        PivotStrategy middlePivot = new MiddlePivot();

        LomutoPartition partitioner = new LomutoPartition();
        HoarePartition hoarePartition = new HoarePartition();

        QuickSort quickSort = new QuickSort(middlePivot, partitioner);
        quickSort.addObserver(new ConsoleObserver());

        System.out.println(Arrays.toString(quickSort.sort(arr)));

        quickSort.setPartitionStrategy(hoarePartition);
        quickSort.setPivotStrategy(new RangePivot());
        System.out.println(Arrays.toString(quickSort.sort(arr1)));
    }
}
