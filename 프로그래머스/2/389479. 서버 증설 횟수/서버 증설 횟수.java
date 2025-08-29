import java.util.*;


class Solution {
    public int solution(int[] players, int m, int k) {
    int answer = 0;
    int currentServers = 0;
    PriorityQueue<int[]> expiryQueue = new PriorityQueue<>((a, b) -> a[0] - b[0]);
    
    for (int i = 0; i < players.length; i++) {
        // 만료된 서버 제거
        while (!expiryQueue.isEmpty() && expiryQueue.peek()[0] <= i) {
            currentServers -= expiryQueue.poll()[1];
        }
        
        // 올바른 서버 필요량 계산
        int requiredServers = players[i] / m;
        
        if (requiredServers > currentServers) {
            int additionalServers = requiredServers - currentServers;
            answer += additionalServers;
            currentServers = requiredServers;
            expiryQueue.offer(new int[]{i + k, additionalServers});
        }
    }
    return answer;
}
}