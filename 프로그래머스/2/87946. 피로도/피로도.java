class Solution {
    public int solution(int k, int[][] dungeons) {

        for (int i = 0 ; i < dungeons.length ; i++) {
            int[] dungeon = dungeons[i];
            int minFigure = dungeon[0];
            int consume = dungeon[1];
            boolean[] visit = new boolean[dungeons.length];

            // 80
            if (minFigure <= k) {
                visit[i] = true;
                dfs(dungeons, visit, 1, k-consume);
            }

        }
        return maxCount;
    }

    int maxCount = Integer.MIN_VALUE;
    private void dfs(int[][] dungeons, boolean[] visit, int countVisit, int leftFigure) {

        for (int i = 0 ; i < dungeons.length ; i++) {
            int[] dungeon = dungeons[i];
            int minFigure = dungeon[0];
            int consume = dungeon[1];

            if (!visit[i] && leftFigure >= minFigure) {
                visit[i] = true;
                dfs(dungeons, visit, countVisit+1, leftFigure-consume);
                visit[i] =false;
            }
        }
        maxCount = Math.max(maxCount, countVisit);
    }
}