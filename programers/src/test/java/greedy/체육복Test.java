package greedy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import stack.다리를_지나는_트럭;

import static org.junit.jupiter.api.Assertions.*;

class 체육복Test {

    @Test
    void test() {
        체육복 test = new 체육복();
        int n = 5;
//        int[] lost = {2,4};
//        int[] reserve = {1,3,5};

//        int[] lost = {1,3,8};
//        int[] reserve = {9,4};

        int[] lost = {2,3};
        int[] reserve = {3,4};


        int solution = test.solution(n, lost, reserve);
        System.out.println("solution = " + solution);
        Assertions.assertEquals(solution, 4);

    }


}