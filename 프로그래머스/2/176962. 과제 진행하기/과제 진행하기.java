
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Stack;

class Solution {
    public String[] solution(String[][] plans) {
        String[] answer = {};
        PriorityQueue<Plan> pq = new PriorityQueue<>();

        for (String[] plan : plans) {
            String name = plan[0];
            String startTime = plan[1];
            String[] times = startTime.split(":");
            String hours = times[0];
            String min = times[1];

            String playtime = plan[2];
            Plan p = new Plan(name, Integer.parseInt(hours) * 60 + Integer.parseInt(min), Integer.parseInt(playtime));
            pq.add(p);
        }


        Stack<Plan> waitStack = new Stack<>();
        ArrayList<String> complete = new ArrayList<>();



        Plan prePlan = pq.poll();
        while (!pq.isEmpty()) {
            Plan p = pq.poll();
            int spendTime = p.startTime - (prePlan.startTime + prePlan.leftPlayTime);

            // 시간 남음
            if (spendTime >= 0) {
                complete.add(prePlan.name);

                // 남은 시간으로 waitTime 체크
                while (!waitStack.isEmpty() && spendTime > 0) {
                    Plan waitPlan = waitStack.pop();
                    int wSpendTime = waitPlan.leftPlayTime - spendTime;
                    if (wSpendTime > 0) {
                        // 아직 남음
                        waitPlan.leftPlayTime = wSpendTime;
                        waitStack.push(waitPlan);
                        break;
                    } else {
                        // 안남았으니,
                        complete.add(waitPlan.name);
                        spendTime = spendTime - waitPlan.leftPlayTime;
                    }
                }
            } else {
                prePlan.leftPlayTime = -spendTime;
                waitStack.push(prePlan);
            }
            prePlan = p;
        }
        complete.add(prePlan.name);

        while (!waitStack.isEmpty()) {
            Plan waitPlan = waitStack.pop();
            complete.add(waitPlan.name);
        }

        return complete.toArray(String[]::new);
    }

    public static class Plan implements Comparable<Plan> {
        String name;
        int startTime;
        int leftPlayTime;

        public Plan(String name, int startTime, int leftPlayTime) {
            this.name = name;
            this.startTime = startTime;
            this.leftPlayTime = leftPlayTime;
        }

        @Override
        public int compareTo(Plan o) {
            return startTime - o.startTime;
        }
    }
}