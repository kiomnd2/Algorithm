
import java.util.*;

class Solution {
    static class State {
        int x, y, time;
        boolean hasLever;
        
        State(int x, int y, int time, boolean hasLever) {
            this.x = x;
            this.y = y;
            this.time = time;
            this.hasLever = hasLever;
        }
    }
    
    public int solution(String[] maps) {
        int height = maps.length;
        int width = maps[0].length();
        
        // visit[x][y][lever] - lever: 0(레버 없음), 1(레버 있음)
        boolean[][][] visited = new boolean[width][height][2];
        
        Queue<State> queue = new LinkedList<>();
        
        // 시작점 찾기
        for (int j = 0; j < height; j++) {
            for (int i = 0; i < width; i++) {
                if (maps[j].charAt(i) == 'S') {
                    queue.offer(new State(i, j, 0, false));
                    visited[i][j][0] = true;
                    break;
                }
            }
        }
        
        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};
        
        while (!queue.isEmpty()) {
            State current = queue.poll();
            
            // 출구에 도달했고 레버를 당겼다면
            if (maps[current.y].charAt(current.x) == 'E' && current.hasLever) {
                return current.time;
            }
            
            for (int k = 0; k < 4; k++) {
                int nx = current.x + dx[k];
                int ny = current.y + dy[k];
                
                // 범위 체크
                if (nx >= 0 && nx < width && ny >= 0 && ny < height) {
                    char cell = maps[ny].charAt(nx);
                    
                    // 벽이 아닌 경우
                    if (cell != 'X') {
                        boolean newHasLever = current.hasLever;
                        
                        // 레버를 발견한 경우
                        if (cell == 'L') {
                            newHasLever = true;
                        }
                        
                        int leverState = newHasLever ? 1 : 0;
                        
                        // 아직 방문하지 않은 상태라면
                        if (!visited[nx][ny][leverState]) {
                            visited[nx][ny][leverState] = true;
                            queue.offer(new State(nx, ny, current.time + 1, newHasLever));
                        }
                    }
                }
            }
        }
        
        return -1;
    }
}