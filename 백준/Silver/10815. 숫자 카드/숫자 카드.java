import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
//        Scanner scanner = new Scanner(System.in);
        BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] minusArr = new int[10000000];
        int[] plusArr = new int[10000000];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i=0 ; i<N ; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (num < 0) {
                minusArr[-num] = 1;
            } else {
                plusArr[num] =1;
            }
        }

        int M = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());

        int[] resultArr = new int[M];
        for (int i=0 ; i < M ; i++) {
            int _num = Integer.parseInt(st.nextToken());
            if (_num < 0) {
                int i1 = minusArr[-_num];
                resultArr[i] = i1;
            } else {
                int i1 = plusArr[_num];
                resultArr[i] = i1;
            }
        }
        StringBuffer sb = new StringBuffer();
        for (int i=0 ; i<resultArr.length ; i++) {
            sb.append(resultArr[i]).append(" ");
        }

        System.out.println(sb);


    }
}