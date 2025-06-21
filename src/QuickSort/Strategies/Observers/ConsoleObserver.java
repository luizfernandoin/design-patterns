package QuickSort.Strategies.Observers;

public class ConsoleObserver implements QuickSortObserver {
    @Override
    public void onSwap(int[] arr, int i, int j) {
        System.out.println("Swap: " + arr[i] + " <--> " + arr[j]);
    }

    @Override
    public void onPartition(int[] arr, int left, int right, int pivot) {
        System.out.println("Partition: left=" + left + ", right=" + right + ", pivot=" + pivot);
    }

    @Override
    public void onRecursion(int left, int right) {
        System.out.println("Recursion on [" + left + ", " + right + "]");
    }
}
