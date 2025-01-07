import java.util.PriorityQueue;


class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // 우선순위 큐에 담음
        for (int i : scoville) {
            pq.add(i);
        }

        int count=0;
             while(pq.peek() < K && pq.size() != 1) {
            count++;
            int minNum = pq.poll();
            int sMinNum = pq.poll();
            // 가장맵지 않은 음식+ 두번째 맵지않은 음식 * 2
            int sum = (minNum + sMinNum*2);
            pq.add(sum);
        }

        if (pq.size() == 1 && pq.peek() < K) return -1;
        return count;
    }
}