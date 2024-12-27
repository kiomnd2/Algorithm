package greedy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class 조이스틱Test {

    @Test
    void test() {
        조이스틱 test = new 조이스틱();

        int solution = test.solution("JAZ");

        Assertions.assertEquals(11, solution);
    }

}