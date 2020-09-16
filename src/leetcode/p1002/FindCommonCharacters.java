package leetcode.p1002;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FindCommonCharacters {
    public static void main(String[] args) {
        String[] a = new String[]{"bella","label","roller"};
        System.out.println(commonChars(a));
    }
    public static List<String> commonChars(String[] A) {
        /*
            Input: ["cool","lock","cook"]
            Output: ["c","o"]
         */

        List<String> r = new ArrayList<>();

        char[] chars = A[0].toCharArray();

        for (char temp : chars) {
            boolean checker = true;
            for (int j = 1; j < A.length; j++) { // 1번 다음부터 시작
                String tempStr = A[j];
                if (tempStr.indexOf(temp) == -1) {
                    checker = false;
                    break;
                }
            }
            if (checker) {
                String s = String.valueOf(temp);
                r.add(s);

                for (int j = 0; j < A.length; j++) {
                    A[j] = A[j].replaceFirst(s, "0");
                }
            }
        }
        return r;
    }
}
