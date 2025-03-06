import java.util.ArrayList;
import java.util.List;

class Solution {
    public int solution(String word) {
        int answer = 0;
        char[] wordList = {'A', 'E', 'I', 'O', 'U'};
        ArrayList<String> strings = new ArrayList<>();
        dfs(strings, "", 0 , wordList);

        String temp = "";
        int i=0;
        while (!temp.equals(word)) {
            temp = strings.get(i++);
        }
        
        return i-1;
    }

    public void dfs(List<String> list, String str, int len, char[] wordList) {
        list.add(str);
        if (len == 5) return;
        for (int i = 0; i < 5; i++) {
            dfs(list, str + wordList[i], len + 1, wordList);
        }
    }
}