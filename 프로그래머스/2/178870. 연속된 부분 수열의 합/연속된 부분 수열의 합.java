class Solution {
    int minDistance = 1000000;
    int minI = 0;
    int minJ = 0;

    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];

        int sum = 0;
        int startIdx = 0;
        for (int i = 0; i < sequence.length; i++) {
            sum += sequence[i];
            if (sum < sequence[i]) continue;

            if (sum == k) {
                minI = startIdx;
                minJ = i;
                minDistance = i - startIdx;
            } else {
                while (sum > k) {
                    sum -= sequence[startIdx++];
                }
                if (sum == k && minDistance > i - startIdx) {
                    minI = startIdx;
                    minJ = i;
                    minDistance = i - startIdx;
                }

            }
        }
        answer[0] = minI;
        answer[1] = minJ;
        return answer;
    }
}