package greedy;

public class 큰숫자 {

    public String solution(String number, int k) {
        char[] numberArr = number.toCharArray();

        int ejectCnt=0;

        for (int i=1; i<numberArr.length; i++) {
            int cnj = 1;
            if (numberArr[i] == 'X') {
                continue;
            }

            // X 의 갯수 지나침
            while (i-cnj > 0 && numberArr[i] == 'X') {
                cnj++;
            }

            if (numberArr[i-cnj] != 'X' && numberArr[i-cnj] < numberArr[i]) {
                numberArr[i-cnj] = 'X';
            } else if (i+1 < numberArr.length && numberArr[i+1] < numberArr[i]) {
                numberArr[i+1] = 'X';
            } else {
                numberArr[i] = 'X';
            }
            ejectCnt++;

            if (ejectCnt == k) break;
        }

        char[] ansChar = new char[numberArr.length-k];
        int kIdx = 0;
        for (char c: numberArr) {
            if (c == 'X') {
                continue;
            }
            ansChar[kIdx++] = c;
        }

        return new String(ansChar);
    }
}
