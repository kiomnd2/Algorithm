class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        int totalWindow = brown + yellow;
        
        int x = 3;
        
        while (totalWindow/x > 0) {
            if (x < totalWindow/x) {
                x++;
                
                continue;
            }
            
            if (totalWindow%x == 0) {
                int y = totalWindow/x;
                
                int dx = x-2;
                int dy = y-2;
                
                if (dx*dy  == yellow) {
                    answer[0] = x;
                    answer[1] = y;
                    return answer;
                }
            }
            x++;
        }
        
        return answer;
    }
}