class Solution {
    int answer = 0;
    public int solution(int[] number) {

        boolean[] visit = new boolean[number.length];
        recursive(number, visit, 0, number.length, 0);

        return answer;
    }

    public void recursive(int[] number, boolean[] visit, int curIdx, int n, int count) {
        if (count == 3) {
            int sum = 0;
            for (int i = 0; i < n; i++) {
                if (visit[i]) {
                    sum += number[i];
                }
            }
            if (sum == 0) answer++;
            return;
        }

        for (int i=curIdx; i< n; i++) {
            visit[i] = true;
            recursive(number, visit, i+1, n, count+1);
            visit[i] = false;
        }
    }
}