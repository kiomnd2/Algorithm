package search;

import java.util.*;

public class 모의고사 {
    public int[] solution(int[] answers) {
        int[] answer = {};

        int[] m1 = new int[]{1,2,3,4,5,1,2,3,4,5};
        int[] m2 = new int[]{2,1,2,3,2,4,2,5};
        int[] m3 = new int[]{3,3,1,1,2,2,4,4,5,5};


        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(1, 0);
        map.put(2, 0);
        map.put(3, 0);

        for (int i=0 ; i < answers.length ; i++) {
            int i1 = m1[i % m1.length];
            int i2 = m2[i % m2.length];
            int i3 = m3[i % m3.length];
            int ans = answers[i];

            if (i1 == ans) {
                map.put(1, map.get(1)+1);
            }
            if (i2 == ans) {
                map.put(2, map.get(2)+1);
            }
            if (i3 == ans) {
                map.put(3, map.get(3)+1);
            }
        }

        int maxValue = Integer.MIN_VALUE;
        int maxKey = -1;
        List<Integer> maxKeys = new ArrayList<>();
        for (Integer key : map.keySet()) {
            Integer keyValue = map.get(key);

            if (keyValue > maxValue) {
                maxValue = keyValue;
                maxKeys.clear();
                maxKeys.add(key);
            } else if (keyValue == maxValue) {
                maxKeys.add(key);
            }
        }

        return maxKeys.stream().mapToInt(Integer::intValue).toArray();
    }
}
