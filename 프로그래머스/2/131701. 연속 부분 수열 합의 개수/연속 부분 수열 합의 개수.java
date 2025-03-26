import java.util.*;


class Solution {
    public int solution(int[] elements) {
        int answer = 0;

        Set<Integer> set = new HashSet<>();


        int len = 1;
        while (len <= elements.length) {

            for (int i = 0 ; i <= elements.length ; i++) {
                int sum = 0;
                for (int j = i ; j < i + len ; j++) {
                    sum += elements[j % elements.length];
                }
                set.add(sum);
            }
            len ++;
        }

        return set.size();
    }
}