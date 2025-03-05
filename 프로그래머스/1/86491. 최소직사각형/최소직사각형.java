class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;

        int maxWidth = -1;
        int maxHeight = -1;
        int aMax = -1;
        int bMax = -1;
        for (int[] size : sizes) {
            int width = size[0];
            int height = size[1];
            int max = Math.max(width, height);
            int min = Math.min(width, height);
            aMax = Math.max(aMax, max);
            bMax = Math.max(bMax, min);
        }

        return aMax * bMax;
    }
}