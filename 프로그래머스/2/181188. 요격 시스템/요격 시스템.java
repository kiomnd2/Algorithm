
import java.util.Arrays;

class Solution {
      public int solution(int[][] targets) {
        int answer = 0;

        Arrays.sort(targets, (o1, o2) -> o1[1] - o2[1]);

        int lastEd = targets[0][1];
        int point = lastEd;
        answer++;
        for (int i=1 ; i < targets.length ; i++) {

            if (point <= targets[i][0]) {
                point = targets[i][1];
                answer++;
            }

        }

        return answer;
    }
}