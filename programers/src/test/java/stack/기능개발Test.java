package stack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class 기능개발Test {

    @Test
    void test() {
        기능개발 ans = new 기능개발();
        int[] progresses = {95, 90, 99, 99, 80, 99};
//        int[] progresses = {0};
//        int[] progresses = {93, 30, 55};
//        int[] speeds = {100};
        int[] speeds = {1, 1, 1, 1, 1, 1};
//        int[] speeds = {1, 30 ,5};

        int[] solution = ans.solution(progresses, speeds);
        for (int i : solution) {
            System.out.println("i = " + i);
        }

    }

}