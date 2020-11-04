package leetcode.p242;

import java.util.ArrayList;

public class ValidAnagram {
    public static void main(String[] args) {
        System.out.println(isAnagram("cat", "rat"));
    }

    public static boolean isAnagram(String s, String t) {
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        ArrayList<Character> checker = new ArrayList<>();
        for (char c : sArr) {
            checker.add(c);
        }

        for (char c : tArr) {
            int i = checker.indexOf(c);
            // 없다면
            if (i == -1) {
                return false;
            } else {
                checker.remove(i);
            }
        }
        return checker.size() == 0;
    }
}
