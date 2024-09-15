import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i=0 ; i<T ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            int[][] beachu = new int[N][M];
            boolean[][] beachuCheck = new boolean[N][M];

            for (int j=0; j<K ; j++) {
                StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
                int X = Integer.parseInt(stringTokenizer.nextToken());
                int Y = Integer.parseInt(stringTokenizer.nextToken());
                beachu[X][Y] = 1;
            }

            int count =0 ;
            for (int j=0 ; j<N ; j++) {
                for (int k=0 ; k<M ; k++) {
                    int i1 = beachu[j][k];
                    boolean ci1 = beachuCheck[j][k];
                    if (i1 == 1 && !ci1 ) {
                        checkBeachu(j, k, beachu, beachuCheck);
                        count ++;
                    }
                }
            }
            System.out.println(count);
        }
    }

    public static void checkBeachu(int curX, int curY, int[][] baechu, boolean[][] baechuCheck) {
        baechuCheck[curX][curY] = true;
        int[] dirX = {-1, 1, 0, 0};
        int[] dirY = {0, 0, -1, 1};

        for (int i=0 ; i<4 ; i++) {
            int dirX1 = curX + dirX[i];
            int dirY1 = curY + dirY[i];

            if (dirX1 < 0 || dirY1 < 0 || dirX1 > baechu.length-1
                    ||  dirY1 > baechu[0].length-1
                    || baechuCheck[dirX1][dirY1]
                    || baechu[dirX1][dirY1] == 0
            ) {
                continue;
            }
            checkBeachu(dirX1, dirY1, baechu, baechuCheck);
        }
    }
}