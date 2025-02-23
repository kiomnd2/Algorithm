class Solution {
    public String solution(String s, String skip, int index) {
        String answer = "";

        for(int i = 0; i < s.length(); i++) {
            char a = s.charAt(i);
            for(int j = 0; j < index; j++) {
                a = (char)(a + 1);
                if(skip.contains(a+"")) j--;
                if((int)a > 122) {
                    a -= 26;
                    if(skip.contains(a+"")) j--;
                }
            }
            answer += a;
        }

        return answer;
    }
}