
import java.util.Arrays;
import java.util.Comparator;
class Solution {
       public int solution(int[] people, int limit) {
        int answer =0;

        Integer[] pepObj = Arrays.stream(people).boxed().toArray(Integer[]::new);
        Arrays.sort(pepObj, Comparator.reverseOrder());

        int rightCnt =0;
        for (int i=0 ; i<pepObj.length - rightCnt ; i++) {
            int p1 = pepObj[i];
            if (p1 == -1) continue;

            if (p1 + pepObj[people.length -1 - rightCnt] <= limit) {
                rightCnt++;
            }
            answer++;
        }
        return answer;
    }
}