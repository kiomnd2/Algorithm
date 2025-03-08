class Solution {
    public int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;
        for (int i = 0; i < absolutes.length; i++) {
            int absolute = absolutes[i];
            boolean sign = signs[i];
            if (sign) {
                answer+=absolute;
            } else {
                answer-=absolute;
            }
        }

        return answer;
    }
}