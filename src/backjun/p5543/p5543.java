package backjun.p5543;

import java.util.Scanner;

public class p5543 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int burger = Integer.MAX_VALUE;
        int drink = Integer.MAX_VALUE;
        for(int i =0; i< 5;  i++)
        {
            int next =  sc.nextInt();
            //햄버거종류
            if(i < 3)
            {
                if( next < burger)
                {
                    burger = next;
                }

            }
            else if (3 <= i && i  < 5) //음료수 종류
            {
                if(next < drink)
                {
                    drink = next;
                }
            }
        }

        System.out.println(burger + drink -50 );

    }
}
