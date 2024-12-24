package stack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class 주식가격Test {

    @Test
    void test() {
        주식가격 ans = new 주식가격();
//        int[] prices = {1, 2, 3, 2, 3};
        int[] prices = {10, 5, 9, 1, 1, 1};
//        int location = 2;
        int location = 0;

        int[] solution = ans.solution(prices);
        for (int i : solution) {
            System.out.println("i = " + i);
        }
    }

}