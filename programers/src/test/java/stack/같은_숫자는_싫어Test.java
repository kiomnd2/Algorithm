package stack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class 같은_숫자는_싫어Test {

    @Test
    void test() {
        같은_숫자는_싫어 ans = new 같은_숫자는_싫어();
        int[] arr = new int[]{1,1,3,3,0,1,1};
        int[] solution = ans.solution(arr);

        for (int i : solution) {
            System.out.println("i = " + i);
        }
    }
}