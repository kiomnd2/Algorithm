package array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class 가장_큰_수Test {

    @Test
    void test() {
        가장_큰_수 test = new 가장_큰_수();
        int[] numbers = {3, 30, 34, 5, 9};
        String solution = test.solution(numbers);
        System.out.println("solution = " + solution);
    }

}