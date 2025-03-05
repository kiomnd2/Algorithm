class Solution {
    public String solution(String s, String skip, int index) {
        StringBuilder sb = new StringBuilder();

        for (int i=0 ; i<s.length() ; i++) {
            char c = s.charAt(i);
            int skipIdx = index;
            int cIdx = ((int)c) + skipIdx;

            for (int j=0 ; j<skip.length() ; j++) {
                char c1 = skip.charAt(j);
                // 스킵할 인덱스가 사이에 있으면
                if (c <= c1 && cIdx >= c1) {
                    skipIdx++; // 스킵할 인덱스 +1
                }
            }


            int i1 = (c + skipIdx);
            if(i1 > 122) { // z 가 넘어가면
                int diff = i1 % 122 -1;
                i1 = 97 + diff;
            }

            sb.append((char)i1);
        }

        return sb.toString();
    }
}