package leetcode.p1011;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ShipWithinDays {
    public static void main(String[] args) {
        System.out.println(shipWithinDays(new int[]{1,2,3,4,5,6,7,8,9,10}, 5));

    }

    public static int shipWithinDays(int[] weights, int D) {
        int answer =0 ;

        int capacity=0 ;
        for(int weight : weights)
        {
            capacity = Math.max(capacity, weight);
        }


        int sum =0 ;
        int day =1;
        for (int weight : weights)
        {
            int nextSum = sum + weight;
            if(nextSum > capacity)
            {



                sum=weight; // sum 값 현재 weight 값으로 초기화
                day++; //일수 1 늘림
            }
            else
            {
                sum+= weight;
            }
        }
        return answer;
    }

}
