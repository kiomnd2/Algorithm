import java.util.ArrayList;
import java.util.Stack;

public class 주식가격 {
    public static void main(String[] args) {

        System.out.println(solution(new int[]{1,2,3,2,3}));
        System.out.println(solution(new int[]{1,2,3,1}));
        System.out.println(solution(new int[]{1,1,1,1,1,1}));
    }

    public static int[] solution(int[] prices) {
        int[] answer;

        answer = new int[prices.length];
        Stack<Integer> stack = new Stack<>();

        for (int i=0 ; i<prices.length ; i++) {
            if (i != 0 && prices[i] < prices[stack.peek()]) {
                while(stack.size() != 0 && prices[stack.peek()] > prices[i]) {
                    answer[stack.peek()] = i - stack.pop();
                }
            }

            stack.add(i);
            answer[i] = prices.length - stack.peek()-1;
        }

        for (int i =0; i<answer.length ; i++ ) {
            System.out.println(answer[i]);
        }

        return answer;
    }
}
