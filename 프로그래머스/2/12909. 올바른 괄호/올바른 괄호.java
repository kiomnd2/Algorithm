
import java.util.Stack;
class Solution {

    public boolean solution(String s) {
        boolean answer = false;

        Stack<Character> stack = new Stack<>();

        char[] charArray = s.toCharArray();

        if (charArray[0] == ')') return false;

        stack.push(charArray[0]);
        for (int i=1 ; i<charArray.length ; i++) {
            char c = charArray[i];
            
            if (stack.size() == 0 && c == ')') {
                return false;
            }

            if (c == ')' && stack.peek() == '(') {
                stack.pop();
            } else if (c == '(') {
                stack.push('(');
            }
        }


        if (stack.size() == 0) return true;

        return answer;
    }
}