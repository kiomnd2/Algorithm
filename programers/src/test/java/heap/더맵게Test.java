package heap;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class 더맵게Test {

    @Test
    void test() {
        더맵게 test = new 더맵게();

        int[] scovile = {1,2,3,9,10,12};
//        int[] scovile = {1,2};
        int K = 7;
        int solution = test.solution(scovile, K);
        System.out.println("solution = " + solution);

    }
}