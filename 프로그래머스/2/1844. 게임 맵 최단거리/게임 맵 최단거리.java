import java.util.LinkedList;
import java.util.Queue;

class Solution {
    int answer = -1;

    public int solution(int[][] maps) {
    
        int[] dirX = {0,0,1,-1};
        int[] dirY = {1,-1,0,0};
        
        int mlength = maps.length;
        int mlength2 = maps[0].length;
        
        boolean[][] visited = new boolean[mlength][mlength2];
        Queue<Node> q = new LinkedList<>();        
        
        Node startNode = new Node(0,0,1);
        visited[0][0] = true;
            
        q.add(startNode);
        
        while (!q.isEmpty()) {
            Node n = q.poll();
            
            if (n.x == mlength-1 && n.y == mlength2-1) {
                return n.cnt;
            }
            
            for (int i=0 ; i<4 ; i++) {
                int xX = n.x + dirX[i];
                int yY = n.y + dirY[i];
                if (xX >= 0 && xX < maps.length && yY >= 0 && yY < maps[0].length 
                    && maps[xX][yY] == 1 && !visited[xX][yY]) {
                    q.add(new Node(xX,yY, n.cnt+1));
                    visited[xX][yY] = true;
                }
            }
        }
        
        return answer;
    }
    
    static class Node {
        int x=0;
        int y=0;
        int cnt =0;
        
        public Node(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
}