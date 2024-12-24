package stack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class 다리를_지나는_트럭Test {

    @Test
    void test() {
        다리를_지나는_트럭 test = new 다리를_지나는_트럭();
        int bridge_length = 2;
        int weight = 10;
        int[] truck_weight = {7,4,5,6};


        test.solution(bridge_length, weight, truck_weight);
    }

}