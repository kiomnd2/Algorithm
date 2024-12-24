import java.util.Stack;

class Solution {
public int[] solution(int[] prices) {
        Stack<Integer> stack = new Stack<>();
        int[] answer = new int[prices.length];

        stack.add(0);

        for (int i = 1 ; i < prices.length ; i++) {
            if (!stack.isEmpty() && prices[stack.peek()] <= prices[i]) {
                stack.add(i);
            } else {
                while (!stack.isEmpty() && prices[stack.peek()] > prices[i]) {
                    Integer pop = stack.pop();
                    answer[pop] = i - pop;
                }
                stack.add(i);
            }
        }

        while (!stack.isEmpty()) {
            int pop = stack.pop();
            answer[pop] = prices.length - (pop + 1);
        }

        return answer;
    }
}   