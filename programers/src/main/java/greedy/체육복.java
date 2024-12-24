package greedy;

import java.util.Arrays;

public class 체육복 {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;

        boolean[] isLend = new boolean[reserve.length];
        boolean[] isGet = new boolean[lost.length];
        int lendCount=0;
        Arrays.sort(lost);
        Arrays.sort(reserve);
        for (int i=0 ; i< lost.length ; i++) {
            for (int j=0 ; j<reserve.length ; j++ ) {
                if (lost[i] == reserve[j]) {
                    isLend[j] = true;
                    isGet[i] = true;
                    lendCount++;
                    break;
                }
            }
        }

        for (int i=0 ; i < lost.length ; i++) {
            int lostOne = lost[i];

            for (int j=0 ; j<reserve.length ; j++) {
                int reserveOne = reserve[j];
                // 자신과 동일한값이 있을 때 이미 빌려줫을 겨웅

                // 현재 값 이전값과 다음사람 값과 동일하다면 && 빌려준게 아니라면
                if ((lostOne-1 == reserveOne || reserveOne == lostOne+1) && !isLend[j] && !isGet[i]) {
                    lendCount++;
                    isLend[j] = true;
                    isGet[i] = true;
                    break;
                }
            }
        }
        return n - lost.length + lendCount;
    }
}
