class Solution {
   public int[] solution(int n, long left, long right) {
        int[] answer = new int[(int)(right-left)+1];
        int idx = 0;

        for (long num=left ; num<=right ; num++) {
            long div = num / n;
            long ll = num % n;

            if (div < ll) {
                answer[idx++] = (int) ll+1 ;
            } else {
                answer[idx++] = (int) div+1;
            }
        }

       

        return answer;
    }
}