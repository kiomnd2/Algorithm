package greedy;

public class 큰숫자 {

    public String solution(String number, int k) {
        char[] numberArr = number.toCharArray();
        char[] ansArr = new char[number.length() - k];

        int ansCnt=0 ;
        int curIdx = 0;
        while(ansCnt != number.length() - k) {
            int max = -1;
            int window = k + ansCnt + 1;
            int tmpIdx = 0;
            for (int i=curIdx ; i< window; i++) {
                if (numberArr[i]-'0' > max) {
                    max = numberArr[i] - '0';
                    tmpIdx = i;
                }
            }
            curIdx = tmpIdx + 1;
            ansArr[ansCnt++] = (char)(max +'0');
        }


        return new String(ansArr);
    }
}
