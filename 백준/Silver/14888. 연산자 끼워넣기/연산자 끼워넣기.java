import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        // 값
        int[] A = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i=0 ; i<N ; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        int[] calc = new int[4];
        // 연산자
        st = new StringTokenizer(br.readLine());
        for (int i=0 ; i<4 ; i++) {
            calc[i] = Integer.parseInt(st.nextToken());
        }

        dfs(A[0], 1, A, calc);
        System.out.println(max);
        System.out.println(min);
    }

    private static void dfs(int value, int curIdx, int[] a, int[] calc) {
        if (a.length == curIdx) {
            min = Math.min(min, value);
            max = Math.max(max, value);
            return;
        }

        for (int i=0 ; i<calc.length ; i++) {

            if (calc[i] > 0) {
                calc[i]--;
                switch (i) {
                    case 0 : {
                        value = value + a[curIdx];
                        break;
                    }
                    case 1 : {
                        value = value - a[curIdx];
                        break;
                    }
                    case 2 : {
                        value = value * a[curIdx];
                        break;
                    }
                    case 3 : {
                        value = value / a[curIdx];
                        break;
                    }
                }

                dfs(value, curIdx+1, a, calc);

                // back 트래킹
                switch (i) {
                    case 0 : {
                        value = value - a[curIdx];
                        break;
                    }
                    case 1 : {
                        value = value + a[curIdx];
                        break;
                    }
                    case 2 : {
                        value = value / a[curIdx] ;
                        break;
                    }
                    case 3 : {
                        value = value * a[curIdx];
                        break;
                    }
                }
                calc[i]++;
            }
        }
    }
}