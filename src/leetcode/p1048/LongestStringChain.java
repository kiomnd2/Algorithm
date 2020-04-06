package p1048;

import java.util.*;

public class LongestStringChain {
    public static void main(String[] args) {
        System.out.println(longestStrChain(new String[]{"a","b","ba","bca","bda","bdca"}));
//        System.out.println(isChain(new String[]{"a","b","ba","bca","bda","bdca"},2,3 ));
    }


    public static  int longestStrChain(String[] words)
    {
        Map<String, Integer> dp = new HashMap<>();
        Arrays.sort(words, (a, b)->a.length() - b.length());

        int answer = 0;
        for (String word : words)
        {
            int max = 0;
            for (int i = 0; i < word.length(); ++i)
            {
                String prev = word.substring(0, i) + word.substring(i + 1);
                max = Math.max(max, dp.getOrDefault(prev, 0) + 1);
            }
            dp.put(word, max);
            answer = Math.max(answer, max);
        }
        return answer;
    }

}