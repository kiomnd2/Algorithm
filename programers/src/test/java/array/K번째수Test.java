package array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class K번째수Test {

    @Test
    void test() {
        int[] array = {1,5,2,6,3,7,4};
        int[][] commands ={{2,5,3}, {4,4,1}, {1,7,3}};
        int[] solution = new K번째수().solution(array, commands);
        for (int i : solution) {
            System.out.println("i = " + i);

        }
    }
}