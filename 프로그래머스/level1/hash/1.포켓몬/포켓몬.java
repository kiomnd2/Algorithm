import java.util.HashMap;

public class 포켓몬 {

    public static void main(String[] args) {

        int solution = new 포켓몬().solution(new int[]{3,3,3,2,2,2});
        System.out.println(solution);
    }

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
