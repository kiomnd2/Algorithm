package leetcode.p692;

import javax.swing.*;
import java.util.*;

public class TopKFrequentWords {
    public static void main(String[] args) {
        System.out.println(topKFrequent(new String[]{"i", "love", "leetcode", "i", "love", "coding"},2));
    }


    //Input: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
    //Output: ["i", "love"]
    public static List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> r = new HashMap<>();
        List<String> ans = new ArrayList<>();
        PriorityQueue<WordQueue> pq = new PriorityQueue<>();

        for (String word : words) {
            if (r.containsKey(word)) {
                r.replace(word, r.get(word) + 1);
            } else {
                r.put(word, 1);
            }
        }

        System.out.println(r);

        r.forEach((s, i) -> {
            pq.add(new WordQueue(s,i));
        });

        for (int i = 0 ; i<k ; i++ )
        {
            ans.add(pq.poll().word);
        }
        return ans;
    }

}
class WordQueue implements Comparable<WordQueue> {
    String word ;
    int count ;

    public WordQueue(String word, int count) {
        this.word = word;
        this.count = count;
    }

    @Override
    public int compareTo(WordQueue wordQueue) {
        // 만약 카운터가 같을 땐
        if( wordQueue.count - this.count == 0 )
        {
            return word.compareTo(wordQueue.word);
        }
        return  wordQueue.count - this.count;
    }
}
