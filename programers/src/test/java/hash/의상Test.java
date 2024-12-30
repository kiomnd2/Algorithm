package hash;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class 의상Test {

    @Test
    void test() {
        의상 test = new 의상();

        String[][] clothes = {{"yellow_hat", "headgear"}
                ,{"blue_sunglasses", "eyewear"}
                ,{"green_turban", "headgear"}};

        int solution = test.solution(clothes);

    }

}