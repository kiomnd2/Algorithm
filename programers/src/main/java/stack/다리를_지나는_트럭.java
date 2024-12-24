package stack;

import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.LinkedBlockingQueue;

public class 다리를_지나는_트럭 {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        Queue<Integer> q = new LinkedBlockingQueue<>();

        for (int truckWeight : truck_weights) {
            q.add(truckWeight);
        }

        

        return answer;
    }
}
