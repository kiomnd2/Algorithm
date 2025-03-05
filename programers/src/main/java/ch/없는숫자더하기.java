package ch;

import java.util.Arrays;

public class 없는숫자더하기 {
    public static void main(String[] args) {
//        int[] arr = {1,2,3,4,6,7,8,0};
        int[] arr = {5,8,4,0,6,7,9};
        int solution = new 없는숫자더하기()
                .solution(arr);
        System.out.println("solution = " + solution);
    }

    public int solution(int[] numbers) {
        int answer = -1;
        int[] arr = new int[10];

        for (int number : numbers) {
            arr[number] = 1;
        }

        int sum = 0;
        for (int i=0 ;i< arr.length ; i++) {
            if (arr[i] == 0) {
                sum += i;
            }
        }

        System.out.println("sum = " + sum);

        return answer;
    }
}
