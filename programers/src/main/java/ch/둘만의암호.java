package ch;

import java.util.Arrays;
import java.util.Collections;

public class 둘만의암호 {

    public static void main(String[] args) {
        String s = "y";
//        String s = "aukks";
        String skip = "baz";
//        String skip = "wbqd";
        int index = 1;
//        int index = 5;

        String solution = new 둘만의암호().solution(s, skip, index);
        System.out.println("solution = " + solution);

    }

    public String solution(String s, String skip, int index) {
        StringBuilder sb = new StringBuilder();

        char[] charArray = skip.toCharArray();
        Arrays.sort(charArray);
        for (int i=0 ; i<s.length() ; i++) {
            char c = s.charAt(i);
            int skipIdx = index;
            int cIdx = ((int)c) + skipIdx;

            for (int j=0 ; j<index ; j++) {
                int nextIdx = ((int) c) + j + 1;

                // 스킵 대상
                if (skip.indexOf((char)nextIdx) == -1) {
                    nextIdx++;
                } else {

                }
            }



            int i1 = (c + skipIdx);
            System.out.println("c = " + (char) i1 +": " + i1);
            if(i1 >= 122) { // z 가 넘어가면
                int diff = i1 % 122 -1;
                i1 = 97 + diff;
            }

            sb.append((char)i1);
        }

        return sb.toString();
    }
}
