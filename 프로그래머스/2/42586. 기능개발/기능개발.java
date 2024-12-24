import java.util.ArrayList;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> progressQ = new LinkedBlockingQueue<>();
        ArrayList<Integer> ans = new ArrayList<>();

        int s = 0;
        int c = 0;

        for (int i=0 ; i<progresses.length ; i++) {
            int progress = progresses[i];
            int speed = speeds[i];

            // 7 , 2, 10
            int calc = (100 - progress) / speed;
            if ((100 - progress) % speed != 0) calc++;
            progressQ.add(calc);
        }

        int prevProgress = 0;
        int count=0;
        while (!progressQ.isEmpty()) {
            Integer progress = progressQ.poll();

            // 최초건
            if (prevProgress == 0) {
                count++;
                prevProgress = progress;
            }
            else { // 두번째 건 이상부터
                if (prevProgress >= progress) {
                    count++;
                } else {
                    prevProgress = progress;
                    ans.add(count);
                    count = 1;
                }
            }
        }

        if (count >= 1) {
            ans.add(count);
        }

        return ans.stream().mapToInt(value -> value).toArray();
    }
}