package sort.quicksort;

public class QuickSort {

    void quickSort(int startIdx, int endIdx, int[] data) {
        if (startIdx>= endIdx) {
            return;
        }

        int temp = 0;
        int i = startIdx+1;
        int j = endIdx;

        while (i <= j) {
            while (data[startIdx] <= data[i]) {
                i++;
            }
            while (data[startIdx] >= data[j] && j > startIdx) {
                j--;
            }

            if (i > j) {
                temp = data[startIdx];
                data[startIdx] = data[j];
                data[j] = temp;
            } else {
                temp = data[j];
                data[j] = data[i];
                data[i] = temp;

            }
        }
        quickSort(startIdx, j-1, data);
        quickSort(j+1, endIdx, data);
    }
}
