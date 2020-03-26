package backjun.p1463;

import java.util.HashMap;
import java.util.Scanner;

public class p1463 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //X가 3으로 나누어 떨어지면, 3으로 나눈다.
        //X가 2로 나누어 떨어지면, 2로 나눈다.
        //1을 뺀다.

        int next = sc.nextInt();
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,0);
        map.put(1,0);

        for( int i =2 ; i <= next ; i ++)
        {
            // 1이면 다음으로..
            //먼저 1로 빼고 시작
            map.put( i , map.get(i -1) +1);
            if( i % 2 == 0 )
            {
                map.put(i , Math.min(map.get(i), map.get(i/2)+1 ));
            }
            if( i % 3 == 0)
            {
                map.put(i , Math.min(map.get(i), map.get(i/3) +1) );
            }
        }

        System.out.println(map.get(next));

    }
}
