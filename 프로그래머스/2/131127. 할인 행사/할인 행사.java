import java.util.HashMap;


class Solution {
     public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;

        HashMap<String, Integer> wantMap = new HashMap<>();

        for (int i=0; i<want.length; i++) {
            wantMap.put(want[i], number[i]);
        }

        for (int day=0 ; day <= discount.length-10 ; day++) {
            HashMap<String, Integer> discountMap = new HashMap<>(wantMap);
            int wantNum = 10;

            for (int i=day ; i < day + 10;  i++) {
                String s = discount[i];
                if (discountMap.containsKey(s) && discountMap.get(s) > 0) {
                    discountMap.put(s, discountMap.get(s) - 1);
                    wantNum--;
                }
            }
            if (wantNum == 0) {
                answer++;
            }
        }


        return answer;
    }
}