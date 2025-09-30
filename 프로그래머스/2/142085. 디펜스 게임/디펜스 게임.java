import java.util.*;


class Solution {
    
     public int solution(int n, int k, int[] enemy) {
        int answer = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        int index = 0;
        for (int i =0 ;i < enemy.length ;i ++) {
            
            int e = enemy[i];
            n -= e;
            pq.add(e);

            if (n < 0) {
                if (k > 0) {
                    Integer e1 = pq.poll();
                    n += e1;
                    k--;
                } else {
                    break;
                }
            }
            answer++;
        }

        return answer;
    }
}