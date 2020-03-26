### Backjun Algorithm


#### 1. 문제 설명
* 3가지 조건
    * X가 3으로 나누어 떨어지면, 3으로 나눈다.
    * X가 2로 나누어 떨어지면, 2로 나눈다.
    * 1을 뺀다.
* 숫자를 입력하여 위 조건을 최소로 수행하여 1을 만드는 문제
* 간단한 dp 문제

#### 2. 코드, 솔루션
    1. 입력한 N 까지의 모든 수에 대해 가장짦은 수행횟수를 모두 기록함
    2. 예를들어 N이 5일 때 1,2,3,4,5 각각에 대해 가장 짦은 수행횟수를 구함


| R | 0 | 1 | 2 | 3 | 4 | 5
|---|---|---|------------|---|---|---|
|   |0  | 0 | R1(2-1) =1 |   |
|   |0  | 0 | R1(2-1) =1 | min( R(3-1) +1, R(3/3) +1 )  | |
|   |0  | 0 | R1(2-1) =1 | min( R(3-1) +1, R(3/3) +1 )   |  min( R(4-1) +1 , R(4/2) +1 )   |
|   |0  | 0 | R1(2-1) =1 | min( R(3-1) +1, R(3/3) +1 )   |  min( R(4-1) +1 , R(4/2) +1 )   | min( R(5-1) )  


```java

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

```