package p2751;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class sort_2751 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] data = new int[N];
        for (int i=0 ; i<N ; i++) {
            data[i] = Integer.parseInt(br.readLine());
        }

        quickSort(0, data.length-1, data);
        for (int datum : data) {
            System.out.println(datum);
        }
    }

    public static void quickSort(int startIdx, int endIdx, int[] data) {
        if (startIdx >= endIdx) {
            return;
        }

        int temp = 0;
        int i = startIdx+1;
        int j = endIdx;

        while (i <= j) {
            while (data[i] <= data[startIdx] && i < endIdx ) {
                i++;
            }
            while (data[j] >= data[startIdx] && j > startIdx) {
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
