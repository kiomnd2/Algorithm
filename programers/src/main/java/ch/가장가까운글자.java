package ch;

import java.util.HashMap;

public class 가장가까운글자 {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
//        HashMap<Character, Integer> map = new HashMap<>();
        for (int i=0 ; i<s.length() ; i++) {
            char c = s.charAt(i);
            if (i == 0) answer[0] = -1;
            else {
                answer[i] = -1;
                int count = 0;
                for (int j=i-1 ; j>=0 ; j--) {
                    char c1 = s.charAt(j);
                    if (c == c1) {
                        answer[i] = count + 1;
                        break;
                    }
                    count++;
                }
            }
        }
        return answer;
    }
}
