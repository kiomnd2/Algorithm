
import java.util.*;

class Solution {
    public int solution(int x, int y, int n) {
    if (x == y) {
        return 0;
    }
    
    Queue<int[]> queue = new LinkedList<>();
    
    queue.offer(new int[]{y, 0}); // {current_value, count}
    
    while (!queue.isEmpty()) {
        int[] current = queue.poll();
        int currentValue = current[0];
        int count = current[1];
        
        // 목표에 도달했는지 확인
        if (currentValue == x) {
            return count;
        }
        
        // 3가지 연산 수행
        // 1. 2로 나누기
        if (currentValue % 2 == 0) {
            int nextValue = currentValue / 2;
            if (nextValue >= x) {
                queue.offer(new int[]{nextValue, count + 1});
            }
        }
        
        // 2. 3으로 나누기  
        if (currentValue % 3 == 0) {
            int nextValue = currentValue / 3;
            if (nextValue >= x) {
                queue.offer(new int[]{nextValue, count + 1});
            }
        }
        
        // 3. n 빼기
        if (currentValue - n >= x) {
            int nextValue = currentValue - n;
                queue.offer(new int[]{nextValue, count + 1});
            
        }
    }
    
    return -1; // 목표에 도달할 수 없는 경우
}
}