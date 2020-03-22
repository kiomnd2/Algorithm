package programmers.level2;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;

public class 디스크컨트롤러 {
    public static void main(String[] args) {
        System.out.println(solution(new int[][] { {0, 3},{5,1},{1, 9}, {2, 6} } ));


    }
    public static int solution(int[][] jobs) {

        //우선 순위 대로 정렬..
        //적은 작업시간 순으로.. 작업 시간은 jobs[1]
        Queue<Job> q = new PriorityQueue<>();
        for (int[] job : jobs) {
             q.offer(new Job(job[0], job[1]));
        }

        //리스트가 element를 가져오고 다루기에 편하니 list로 담는다
        ArrayList<Job> list = new ArrayList<>();
        for (int i = 0; i < jobs.length; i++) {
            list.add(q.poll());
        }

        int total = 0 ;
        int pre =0 ;
        while(list.size() >0)
        {
                for(int i =0; i< list.size() ; i++)
                {
                    if(pre >= list.get(i).getStart())
                    {
                        pre += list.get(i).getEnd();
                        total += pre - list.get(i).getStart();

                        System.out.println("s  :: " + list.get(i).getStart() +" e ::"+ list.get(i).getEnd() + " pre ::: " +pre);
                        list.remove(i);
                        break;
                    }
                    if( i == list.size() -1 ) pre ++;
                }
        }

        return total/jobs.length;
    }
}
class Job implements Comparable<Job>
{

    private int start;
    private int end;

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

    public Job(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Job o) {
        return this.getEnd() - o.getEnd();
    }
}
