import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;

public class 기능개발 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{93, 30, 55}, new int[] {1, 30, 5}));
        System.out.println(solution(new int[]{95, 90, 99, 99, 80, 99}, new int[] {1, 1, 1, 1, 1, 1}));

    }

    public static int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};

        Queue<Integer> queue = new LinkedBlockingQueue<>();
//        ArrayList<Integer> list = new ArrayList<>();
        HashMap<Integer, Integer> map = new LinkedHashMap<>();
        for (int progress : progresses) {
            queue.add(progress);
        }

        int round=1;
        for (int speed : speeds) {
            if (!queue.isEmpty()) {
                int progress = queue.peek() + (speed * round);
                while (progress < 100) {
                    round++;
                    progress = queue.peek() + (speed * round);
                }
                queue.poll();
                map.put(round, map.getOrDefault(round, 0)+1);
            }
        }


        System.out.println(map);

        answer = new int[map.values().size()];

        int idx=0;
        for (Integer value : map.values()) {
            answer[idx++] = value;
        }

        return answer;
    }
}
