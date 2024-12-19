package sort.quicksort;

import org.junit.jupiter.api.Test;

class QuickSortTest {

    @Test
    void quickSortTest() {
        QuickSort quickSort = new QuickSort();
        int[] data = new int[]{3,4,6,7,8,2,10,11};
        int[] sorted = new int[]{2,3,4,6,7,8,10,11};

        quickSort.quickSort(0, data.length - 1, data);

        for (int i : sorted) {
            System.out.println("i = " + i);
        }

    }
}