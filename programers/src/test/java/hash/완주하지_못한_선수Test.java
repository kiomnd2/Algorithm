package hash;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class 완주하지_못한_선수Test {

    @Test
    void test() {
        완주하지_못한_선수 test = new 완주하지_못한_선수();
        String[] participant = {"mislav", "stanko", "mislav", "ana"};
        String[] completion = {"stanko", "ana", "mislav"};

        String solution = test.solution(participant, completion);
        System.out.println("solution = " + solution);

    }
}