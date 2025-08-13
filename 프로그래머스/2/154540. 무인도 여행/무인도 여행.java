import java.util.ArrayList;
import java.util.Comparator;

class Solution {
    Integer calc = 0;
    public int[] solution(String[] maps) {
        int[] answer = {};
        
        ArrayList<Integer> result = new ArrayList<>();
        boolean[][] visit = new boolean[maps.length][maps[0].length()];
        for (int i=0 ; i<maps.length ;i++) {
            String rows = maps[i];
            for (int j=0 ; j<rows.length(); j++) {
                char value = rows.charAt(j);
                
                if (value != 'X' && !visit[i][j]) {
                    dfs(maps, visit, i, j);
                    result.add(calc);
                    calc= 0;
                }
            }
        }
        
        if(result.size() == 0 ) return new int[]{-1};
        else {
            result.sort(Comparator.naturalOrder());
        }
        
        return result.stream().mapToInt(value -> value).toArray();
    }
    
    public void dfs(String[] maps, boolean[][] visit, int x, int y) {
        char value = maps[x].charAt(y);
        visit[x][y] = true;
        
        if (value == 'X') {
            return;
        } else {
            
            calc += Character.getNumericValue(value);
        }
        
        int[] dirX = {0, 0, 1, -1};
        int[] dirY = {1, -1, 0, 0};
        
        for (int i=0 ; i<dirX.length ; i++) {
            int moveX = x + dirX[i];
            int moveY = y + dirY[i];
            
            if (moveX >= 0 && moveX < maps.length && moveY >= 0 && moveY < maps[0].length()) {
                if (!visit[moveX][moveY] && maps[moveX].charAt(moveY) != 'X') {
                    dfs(maps, visit, moveX, moveY);
                }
            }
        }
    }
}