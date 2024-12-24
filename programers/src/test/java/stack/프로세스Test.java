package stack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class 프로세스Test {

    @Test
    void test() {
        프로세스 ans = new 프로세스();
        int[] priorities = {2,1,3,2};
//        int[] priorities = {1, 1, 9, 1, 1, 1};
        int location = 2;
//        int location = 0;

        int solution = ans.solution(priorities, location);
        System.out.println("solution = " + solution);
    }
}