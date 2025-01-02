package array;

import java.util.Arrays;

public class K번째수 {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for (int a=0 ; a<commands.length ; a++) {
            int[] command = commands[a];
            int i = command[0];
            int j = command[1];
            int k = command[2];
            int[] tempArr = new int[j-i+1];
            for (int d=i ;d<=j ; d++) {
                tempArr[d-i] = array[d-1];
            }
            Arrays.sort(tempArr);
            answer[a] = tempArr[k-1];
        }

        return answer;
    }
}
