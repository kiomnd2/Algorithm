
import java.util.Comparator;
import java.util.PriorityQueue;
class Solution {
     public int solution(int[][] jobs) {
        int answer = 0;

        PriorityQueue<Work> pq= new PriorityQueue<>(1, new WorkComparator());

        for (int i=0; i < jobs.length ; i++) {
            int[] job = jobs[i];
            int startTime = job[0];
            int endTime = job[1];
            Work work = new Work(i, startTime , endTime);
            pq.add(work);
        }

        int curTime=0;
         while (!pq.isEmpty()) {
            Work poll = pq.poll();
            int diff = 0;
            if (curTime >= poll.startTime) {
                diff = curTime + poll.endTime - poll.startTime;
            } else {
                diff = poll.endTime - poll.startTime;
            }
            curTime += diff;
        }
        answer = curTime / jobs.length;
        return answer;
    }

    class Work {
        int number;
        int startTime;
        int endTime;

        public Work(int number, int startTime, int endTime) {
            this.number = number;
            this.startTime = startTime;
            this.endTime = endTime;
        }

        public int workTime() {
            return endTime + startTime;
        }

        @Override
        public String toString() {
            return number + " : "+ workTime();
        }
    }

    class WorkComparator implements Comparator<Work> {

        @Override
        public int compare(Work o1, Work o2) {
            return o1.workTime() - o2.workTime();
        }
    }
}