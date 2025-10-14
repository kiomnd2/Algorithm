import java.util.*;

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        
        int curNum = 1;
        Stack<Integer> stack = new Stack();
        for (int i=0 ; i<order.length ; i++) {
            int o = order[i];
            
            while (curNum < o) {
                stack.add(curNum++);
            }
            
            if (curNum == o) {
                answer++;
                curNum++;
            } else if (!stack.isEmpty() && stack.peek() == o) {
                    stack.pop();
                    answer++;
            } else {
                break;
            }
    
        }
        
        return answer;
    }
}