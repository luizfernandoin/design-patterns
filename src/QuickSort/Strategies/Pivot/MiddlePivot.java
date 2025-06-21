package QuickSort.Strategies.Pivot;

public class MiddlePivot implements PivotStrategy {
    @Override
    public int escolherPivot(int[] arr, int left, int right) {
        /*
        [1, 2, 3, 4, 5, 6, 7, 8, 9, 0]
        left = 6
        right = 9

        [6, 7, 8, 9, 0]

        (i + j) / 2 = (6 + 9) / 2 = 7

        6 + (3 + 1)
        */

        return (left + right) / 2;
    }
}
