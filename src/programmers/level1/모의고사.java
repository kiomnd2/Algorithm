package level1;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class 모의고사 {
    public static void main(String[] args) {

        //[1,2,3]
        int[] answer = {1,3,2,4,2};
        int[] result = solution(answer);
        for(int i =0 ; i< result.length ; i++)
        {
            System.out.println(result[i]);
        }
    }
    public static int[] solution(int[] answers) {
        int[] answer = {};



        //문제 수에 따라 배열 생성
        //1,2,3,4,5
        //2,1,2,3,2,4,2,5
        //3,3,1,1,2,2,4,4,5,5
        int[][] p = {{1,2,3,4,5}, {2,1,2,3,2,4,2,5}, {3,3,1,1,2,2,4,4,5,5} };
        int[] point = {0,0,0};


        for( int i =0 ; i < answers.length ; i++)
        {
            for ( int j =0 ; j < p.length ; j ++ )
            {
                int r = i%p[j].length;
                if(p[j][r] == answers[i])
                {
                    point[j]++;
                }
            }

        }

        ArrayList<Integer> list = new ArrayList<>();
        int max =0;
        for ( int i =0 ; i< point.length ; i++ )
        {
            if( list.size()  == 0 )
            {
                list.add( i+1 );
                max = point[i];
            }
            else if( max == point[i])
            {
                list.add(i+1);
            }
            else if( max < point[i])
            {
                list.clear();
                list.add(i+1);
                max = point[i];
            }
        }

        answer = new int[list.size()];
        for( int i =0; i<list.size() ; i++) answer[i] = list.get(i);

        return answer;
    }
}
