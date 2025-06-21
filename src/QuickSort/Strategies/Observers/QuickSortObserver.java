package QuickSort.Strategies.Observers;

public interface QuickSortObserver {
    void onSwap(int[] arr, int i, int j);
    void onPartition(int[] arr, int left, int right, int pivot);
    void onRecursion(int left, int right);
}
