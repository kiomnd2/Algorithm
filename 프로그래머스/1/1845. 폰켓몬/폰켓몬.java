import java.util.HashMap;


class Solution {
 public int solution(int[] nums) {
        int answer = 0;
        HashMap<Integer, Integer> poketmon = new HashMap<>();

        for (int num : nums) {
            poketmon.put(num, poketmon.getOrDefault(num, 0)+1);
        }

        int maxPoke = nums.length / 2;

        long count = poketmon.keySet().size();
        if( count > maxPoke) {
            answer = maxPoke;
        } else {
            answer = (int) count;
        }
        return answer;
    }
}