import java.util.*;

class Solution {
    public int solution(int[] arr) {
        int answer = 0; 
        Queue<Integer> q = new LinkedList<>();
        
        for (int i=0 ; i<arr.length ; i++) {
            q.add(arr[i]);
        }
        
        Arrays.sort(arr);
        
        while (!q.isEmpty()) {
            Integer n = q.poll();
            
            if (q.isEmpty()) {
                answer = n; 
                break;
            } else {
                Integer n2 = q.poll();
                int lcm = lcm(n2, n);
                q.add(n/lcm*n2);
            }            
            
        }
        return answer;
    }
    static int lcm(int a, int b) {
        if (a%b==0) {
            return b;
        }
        return lcm(b, a%b);
    }
}