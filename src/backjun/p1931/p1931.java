package backjun.p1931;

import java.util.*;
class Time implements Comparable<Time> {
    private int startTime;
    private int endTime;


    public Time(int startTime, int endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public int getStartTime() {
        return startTime;
    }

    public int getEndTime() {
        return endTime;
    }

    @Override
    public int compareTo(Time o) {
        if (this.getEndTime() == o.getEndTime()) // 종료 시간이 같으면 ?
        {
            return this.getStartTime() - o.getStartTime();
        } else // 종료 시간이 다르면
        {
            return this.getEndTime() - o.getEndTime();
        }
    }

    @Override
    public String toString() {
        return "Time{" +
                "startTime=" + startTime +
                ", endTime=" + endTime +
                '}';
    }
}
public class p1931 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int nextInt = sc.nextInt();

        PriorityQueue<Time> queue = new PriorityQueue<>();
        for (int i = 0; i < nextInt; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            queue.offer(new Time(s,e));
        }




        //1 4
        //3 5
        //0 6
        //5 7
        //3 8
        //5 9
        //6 10
        //8 11
        //8 12
        //2 13
        //12 14

        Time time = queue.poll();
        int max =1 ;
        while(!queue.isEmpty())
        {
            Time nextTime = queue.poll();
            if(nextTime.getStartTime() >= time.getEndTime())
            {
                max ++;
                time = nextTime;
            }
        }

        System.out.println(max);

/*
        int ans = 1;
        for (int i = 0; i < arr.length; i++) {
            int max = 1;
            int s1 = arr[i][0]; // 시작시간
            int e1 = arr[i][1];// 종료시간


            for (int j = i + 1; j < arr.length; j++) {
                int s2 = arr[j][0]; //비교대상의 첫번째 시간 시작시간의 마지막과 비교한다.
                int e2 = arr[j][1];

                // 다음에 올 수들이 이전의 끝난 시간보다 많아야 한다.
                if (s2 >= e1) {
                    //비교 대상을 바꿈
                    s1 = s2;
                    e1 = e2;
                    max++;
                }
            }
            if (max > ans)
                ans = max;
        }
        System.out.println(ans);
    }*/
    }
}
