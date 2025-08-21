import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        
        Queue<Integer> q = new LinkedBlockingQueue<>();
        for (int i=0 ; i<bridge_length ; i++) {
            q.add(0);
        }
        
        int time = 0;
        int order = 0;
        int totalWeight = 0;
        
        while(!q.isEmpty() ) {
            time++;
            totalWeight -= q.poll();
            
            if (q.size() <= bridge_length && order < truck_weights.length) {
                if (totalWeight + truck_weights[order] <= weight) {
                    totalWeight += truck_weights[order];
                    q.add(truck_weights[order]);
                    
                    order++;
                } else {
                    q.add(0);
                }
            }
        }
        
        return time;
    }
}