package QuickSort.Strategies.Pivot;

import java.util.Arrays;
import java.util.Random;

public class RangePivot implements PivotStrategy {
    private final Random random = new Random();

    @Override
    public int escolherPivot(int[] arr, int left, int right) {
        /*
        [1, 2, 3, 4, 5, 6, 7, 8, 9, 0]
        left = 6
        right = 9

        6 + (3 + 1)
        */

        return left + random.nextInt(right - left + 1);
    }
}
