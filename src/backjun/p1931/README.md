### Backjun Algorithm

## 회의실 배정

#### 1. 문제 설명
* 회의실을 시간대순으로 나열하여 가장 많이 회이실을 사용하는 횟수를 리턴
* 예)
~~~
11
1 4
3 5
0 6
5 7
3 8
5 9
6 10
8 11
8 12
2 13
12 14

답 : 4  (1,4), (5,7), (8,11), (12,14) 를 이용할 수 있다
~~~



#### 2. 코드, 솔루션

1. 탐욕법 수행을 위해 가장 짦은 시간을 가진 회의 순으로 나열해야한다
    * 회의 종료 시간 순으로 먼저 정렬
    * 만약 회의 종료 시간이 일치한다면 시작 순으로 정렬한다.
2. 비교 대상을 정하고 다음 대상과 비교한다.
    * 만약 비교대상의 회의 종료 시간과 다음 대상의 시작시간을 비교해 다음 대상의 시작시간이 더 크다면 카운트후 포인터를 다음 대상으로 넘겨 반복해서 비교

 0  |  1  |  2  |  3  |  4  |  5  |  6  |  7  |  8  |  9  |  10  |  11  |  12  |  13  |  14  |
 -----|-----|-----|-----|-----|-----|-----|-----|-----|-----|------|------|------|------|------|
    ,   |  ㅇ  | ㅇ  |  ㅇ |  ㅇ  |    |     |    |     |      |      |     |       |     |      |
   ,   |  ,  | ,  |  ㅇ |  ㅇ  |  ㅇ  |  ,  | , | , | , | , | , | , |, | , |
   ㅇ   |  ㅇ  | ㅇ  |  ㅇ |  ㅇ  |  ㅇ  |  ㅇ  | , | , | , | , | , | , |, | , |
   ,   |  ,  | ,  |  , |  ,  |  ㅇ  |  ㅇ  | ㅇ | , | , | , | , | , |, | , |
   ,   |  ,  | ,  |  ㅇ |  ㅇ  |  ㅇ  |  ㅇ  | ㅇ | ㅇ | , | , | , | , |, | , |
   ,   |  ,  | ,  |  , |  ,  |  ㅇ  |  ㅇ  | ㅇ | ㅇ | ㅇ | , | , | , |, | , |
   ,   |  ,  | ,  |  , |  ,  |  ,  |  ㅇ  | ㅇ | ㅇ | ㅇ | ㅇ | , | , |, | , |
   ,   |  ,  | ,  |  , |  ,  |  ,  |  ,  | , | ㅇ | ㅇ | ㅇ | ㅇ | , |, | , |
   ,   |  ,  | ,  |  , |  ,  |  ,  |  ,  | , | ㅇ | ㅇ | ㅇ | ㅇ | ㅇ |, | , |
   ,   |  ,  | ㅇ  |  ㅇ |  ㅇ  |  ㅇ  |  ㅇ  | ㅇ | ㅇ | ㅇ | ㅇ | ㅇ | ㅇ | ㅇ | , |
   ,   |  ,  | ,  |  , |  ,  |  ,  |  ,  | , | , | , | , | , | ㅇ | ㅇ | ㅇ |
   

~~~java
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

    }
}
~~~
* 우선순위 큐를 사용하여 회의 종료 순으로 정렬 ( poll 시 정렬된다)