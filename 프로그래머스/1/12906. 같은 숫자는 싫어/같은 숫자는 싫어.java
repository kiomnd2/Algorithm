import java.util.*;

public class Solution {
    public int[] solution(int []arr) {

        Stack<Integer> stack = new Stack<>();
        stack.push(arr[0]);

        for (int i=1 ; i<arr.length ; i++) {
            int n1 = arr[i];
            // 같지 않을때만 put
            if (stack.peek() != n1) {
                stack.push(n1);
            }
        }

        return stack.stream().mapToInt(value -> value).toArray();
    }
}