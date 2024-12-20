package stack;

import java.util.ArrayList;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class 기능개발 {
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
//    public int[] solution(int[] progresses, int[] speeds) {
//        Stack<Integer> stack = new Stack<>();
//        ArrayList<Integer> ans = new ArrayList<>();
//
//        if (progresses.length == 1) {
//            return new int[]{1};
//        }
//
//        for (int i=0 ; i < progresses.length ; i++) {
//            int progress = progresses[i];
//            int calc = (100 - progress) / speeds[i];
//
//            if (100 <= progress + (speeds[i] * calc)) {
//                if (!stack.isEmpty()) {
//                    stack.push(stack.pop()+1);
//                }
//            } else {
//                if (!stack.isEmpty()) {
//                    ans.add(stack.pop());
//                }
//                // 완료 안돼었을때 완료 까지 처리할 수 있는 최적화된 시간 구함
//                stack.add(1);
//            }
//        }
//
//        if (!stack.isEmpty()) ans.add(stack.pop());
//
//        return ans.stream().mapToInt(value -> value).toArray();
//    }


}
