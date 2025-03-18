class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int level = 0;

        int min = 1;
        int max = 300000;

        while(min < max) {
            level = (min + max) / 2;

            if (isResolve(diffs, times, limit, level)) {
                max = level;
            } else {
                min = level+1;
            }
        }

        return max;
    }

    private boolean isResolve(int[] diffs, int[] times, long limit, int level) {
        long n=0;
        int prev=0;
        for (int i = 0; i < diffs.length; i++) {
            int diff = diffs[i];
            int time = times[i];
            int oop = level - diff;

            // 양수면 level 이 앞섬
            if (oop >= 0) {
                n += time;
            } else { // 음수면
                int d = diff - level;
                long i1 = (time + prev)*d + time;
                n+=i1;
            }
            prev = time;
        }
        return (n <= limit);
    }
}