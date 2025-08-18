
import java.util.Arrays;

class Solution {
   
    
    public int solution(String[] board) {

        int[][] visit = new int[board.length][board[0].length()];

        for (int i = 0; i < board.length; i++) {
            Arrays.fill(visit[i], Integer.MAX_VALUE);
        }

        for (int i = 0; i < board.length; i++) {
            String row = board[i];
            for (int j = 0; j < row.length(); j++) {
                char c = row.charAt(j);
                if (c == 'R') {
                    visit[i][j] = 0;
                    dfs(board, visit, j, i, 0);
                    break;
                }
            }
        }

        if (minCount == Integer.MAX_VALUE) {
            return -1;
        }

        return minCount;
    }

    int minCount = Integer.MAX_VALUE;

    public void dfs(String[] board, int[][] visit, int x, int y, int count) {
        if (board[y].charAt(x) == 'G') {
            minCount = Math.min(minCount, count);
            return;
        }

        int[] dirX = {0, 0, 1, -1};
        int[] dirY = {1, -1, 0, 0};
        for (int i = 0; i < 4; i++) {
            int copyX = x;
            int copyY = y;
            while(copyX + dirX[i] >= 0 && copyX + dirX[i] < board[0].length()
                    && copyY + dirY[i] >= 0 && copyY + dirY[i] < board.length) {
                if (board[copyY+dirY[i]].charAt(copyX + dirX[i]) == 'D') {
                    break;
                }

                copyX += dirX[i];
                copyY += dirY[i];
            }


            if (visit[copyY][copyX] >= count) {
                visit[copyY][copyX] = count;
                dfs(board, visit, copyX, copyY, count + 1);
            }
        }

    }
}