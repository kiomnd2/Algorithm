import java.util.Stack;

class Solution {
    public int solution(String s) {
        int answer = -1;
        Stack<Character> stack = new Stack<>();
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            String rotated = rotateLeft(s, i);
            boolean flag = true;
            for (int j=0; j<rotated.length(); j++) {
                if (stack.empty()) {
                    char c = rotated.charAt(j);
                    if (c ==']' || c == '}' || c == ')') {
                        flag = false;
                        break;
                    } else {
                        stack.push(c);
                    }
                } else {
                    Character peek = stack.peek();
                    if (peek == '[' && rotated.charAt(j) == ']'
                            || peek == '{' && rotated.charAt(j) == '}'
                            || peek == '(' && rotated.charAt(j) == ')') {
                        stack.pop();
                        flag = true;
                    } else {
                        stack.push(rotated.charAt(j));
                    }
                }
            }
            if (flag && stack.empty()) {
                count++;
            }
        }

        answer = count;
        return answer;
    }

    public String rotateLeft(String s, int size) {
        char[] temp = new char[s.length()];
        for (int i=0 ; i<s.length() ; i++) {
            int i1 = i - size;
            if (i1 < 0) {
                int i2 = s.length() + i1;
                temp[i2] = s.charAt(i);
            } else {
                temp[i1] = s.charAt(i);
            }
        }
        return new String(temp);
    }
}