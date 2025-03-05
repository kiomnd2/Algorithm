
import java.util.*;
public class Solution {
    
    public static int solution(int n, int w, int num) {
        List<Integer> store = new ArrayList<>();
        int answer = 0;
        
        for (int i = 1; i < w * 2; i += 2) {
            store.add(i);
        }
        
        store.sort(Collections.reverseOrder());
        
        int floor = num / w - (num % w == 0 ? 1 : 0);
        int nextNum = num;
        
        while (nextNum <= n) {
            int addNum = (nextNum % w == 0) ? w : nextNum % w;
            nextNum = nextNum + store.get(addNum - 1);
            answer++;
            floor++;
        }
        
        return answer;
    }

}