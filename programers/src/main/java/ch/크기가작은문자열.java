package ch;

public class 크기가작은문자열 {

    public int solution(String t, String p) {
        int answer = 0;

        int windowSize = p.length();
        long pNum = Long.parseLong(p);

        for (int i=0 ; i<t.length()-windowSize+1; i++) {
            String n = t.substring(i, i + windowSize);
            long num = Long.parseLong(n);

            if ( num <= pNum) {
                answer++;
            }

        }

        return answer;
    }
}
