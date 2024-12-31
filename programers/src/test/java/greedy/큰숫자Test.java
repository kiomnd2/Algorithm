package greedy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class 큰숫자Test {

    @Test
    void test() {
        큰숫자 n = new 큰숫자();
//        String solution = n.solution("1924", 2);
//        String solution = n.solution("1231234", 3);
        String solution = n.solution("4177252841", 4);
        System.out.println("solution = " + solution);

    }

}