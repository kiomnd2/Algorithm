import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int result = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        char[][] campus = new char[N][M];
        boolean[][] visit = new boolean[N][M];
        int doX = 0;
        int doY = 0;
        for (int i=0 ; i<N ; i++) {
            String line = br.readLine();
            for (int j=0 ; j<line.length() ; j++) {
                char v = line.charAt(j);
                campus[i][j] = v;
                if ('I' == v) {
                    doX = i;
                    doY = j;
                    visit[doX][doY] = true;
                }
            }
        }

        dfs(campus, visit, doX, doY);
        if (result > 0) {
            System.out.print(result);
        } else {
            System.out.print("TT");
        }
    }

    public static void dfs(char[][] campus, boolean[][] visit, int x, int y) {
        if (campus[x][y] == 'P') {
            result++;
        }

        // 북, 남, 서, 동
        int[] dirX = {-1, 1, 0, 0};
        int[] dirY = {0, 0, -1, 1};

        for (int i=0 ; i<dirX.length ; i++) {
            int curX = x + dirX[i];
            int curY = y + dirY[i];

            // 0 이 아니고 벽이 아니고, 방문한적 없는곳
            if (curX >= 0 && curY >= 0
                    && curX < campus.length
                    && curY < campus[0].length
                    && campus[curX][curY] != 'X'
                    && !visit[curX][curY]) {
                visit[curX][curY] = true;
                dfs(campus, visit, curX, curY);
            }
        }
    }
}