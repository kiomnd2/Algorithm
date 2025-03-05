package ch;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class 가장가까운글자Test {

    @Test
    void test() {
        String s = "foobar";
        int[] solution = new 가장가까운글자().solution(s);
        for (int i : solution) {
            System.out.println("i = " + i);
        }
    }
}