import java.util.LinkedList;
import java.util.Queue;

class Solution {
    int answer = -1;

    public int solution(int[][] maps) {
        boolean[][] visited = new boolean[maps.length][maps[0].length];
//        dfs(maps,0, 0, 1, visited);
        int answer = bfs(maps);
        return answer;
    }

    
    
    public int bfs(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;

        int[] xDir = {0, 0, 1, -1};
        int[] yDir = {1, -1, 0, 0};

        boolean[][] visited = new boolean[n][m];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0, 1});
        visited[0][0] = true;

        while(!queue.isEmpty()){ // bfs
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            int cnt = current[2];

            if(x == n-1 && y == m-1){
                return cnt; // 최단 거리 반환 (bfs: 가장 처음 return 되는게 최단 거리)
            }

            for(int i=0;i<4;i++){
                int nx = x + xDir[i];
                int ny = y + yDir[i];

                if(nx >=0 && ny >= 0 && nx < n && ny < m && maps[nx][ny] == 1 && !visited[nx][ny]){
                    visited[nx][ny] = true;
                    queue.add(new int[]{nx, ny, cnt+1});
                }
            }
        }

        return -1;
    }

}