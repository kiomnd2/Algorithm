package heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class 디스크컨트롤러 {

    public int solution(int[][] jobs) {
        int answer = 0;
        ArrayList<Work> list = new ArrayList<>();
        PriorityQueue<Work> pq= new PriorityQueue<>(1, new WorkComparator());


        // 실행 순서대로 정렬
        for (int i=0; i < jobs.length ; i++) {
            int[] job = jobs[i];
            int startTime = job[0];
            int endTime = job[1];
            Work work = new Work(i, startTime , endTime);
            list.add(work);
        }

        // 작업요청 순으로 정렬
        Collections.sort(list, Comparator.comparingInt(o -> o.startTime));



        int index=0;
        int count=0;
        int curTime =0;
        while (!pq.isEmpty() || index < list.size()) {

            // 현재 인덱스가 list의 사이즈보다 작고, 현재 의 시작시간이
            while (index < list.size() && list.get(index).startTime <= curTime) {
                pq.offer(list.get(index++));
            }

            if (pq.isEmpty()) {
                curTime = list.get(index).startTime;
            } else {
                Work w = pq.poll();
                curTime += w.endTime;
                answer += curTime - w.startTime;
            }
        }
        return answer / list.size();
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
            return number + " : " + startTime;
        }
    }

    class WorkComparator implements Comparator<Work> {

        @Override
        public int compare(Work o1, Work o2) {
            return o1.endTime - o2.endTime;
        }
    }
}
