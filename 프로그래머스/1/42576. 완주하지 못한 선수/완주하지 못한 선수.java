
import java.util.HashMap;
class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> map = new HashMap<>();
        for (String s : participant) {
            map.put(s, map.getOrDefault(s,0) +1 );
        }

        for (String s : completion) {
            Integer getCompletion = map.get(s);
            map.put(s, getCompletion-1);
        }

        for (String s : map.keySet()) {
            if (map.get(s) > 0) {
                answer = s;
            }
        }

        return answer;
    }
}