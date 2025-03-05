package ch;

import java.util.Arrays;

public class 삼총사 {
    public static void main(String[] args) {
        int[] n = {-3, -2, -1, 0, 1, 2, 3};
        int solution = new 삼총사().solution(n);
        System.out.println("solution = " + solution);

    }

    int answer = 0;
    public int solution(int[] number) {

        Arrays.sort(number);
        boolean[] visit = new boolean[number.length];
        recursive(number, visit, 0, number.length, 0);

        return answer;
    }

    public void recursive(int[] number, boolean[] visit, int curIdx, int n, int count) {
        if (count == 3) {
            int sum = 0;
            for (int i = 0; i < n; i++) {
                if (visit[i]) {
                    sum += number[i];
                }
            }
            if (sum == 0) answer++;
            return;
        }

        for (int i=curIdx; i< n; i++) {
            visit[i] = true;
            recursive(number, visit, i+1, n, count+1);
            visit[i] = false;
        }
    }
}
