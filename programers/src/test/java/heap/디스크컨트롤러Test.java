package heap;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class 디스크컨트롤러Test {

    @Test
    void test() {
        디스크컨트롤러 test = new 디스크컨트롤러();
        int[][] jobs = {{0, 3}, {1, 9}, {3, 5}};
        int solution = test.solution(jobs);
        System.out.println("solution = " + solution);

    }

}