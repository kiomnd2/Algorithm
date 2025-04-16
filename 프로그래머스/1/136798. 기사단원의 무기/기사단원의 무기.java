class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 0;


        for (int num = 1; num <= number; num++) {
            int measure = 0;

            for (int i = 1; i <= num; i++) {

                if ((num / 2) + 1 < i) {
                    measure ++;
                    break;
                }


                if (num % i == 0) {
                    measure ++;
                }
            }

            if (measure > limit) {
                answer += power;
            } else {
                answer += measure;
            }
        }

        return answer;
    }
}