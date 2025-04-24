class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;

        boolean[] notPainted = new boolean[n];

        for (int i=0 ; i<section.length ; i++) {
            int s = section[i];
            notPainted[s-1] = true;
        }

        for (int i = 0; i < n; i++) {
            if (notPainted[i]) {
                for (int j = 0 ; j<m ; j++) {
                    if (i+j < n && notPainted[i+j]) {
                        notPainted[i+j] = false;
                    }
                }
                answer++;
            }
        }

        return answer;
    }
}