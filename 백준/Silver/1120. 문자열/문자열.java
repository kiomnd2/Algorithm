import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());

        String A = stringTokenizer.nextToken();
        String B = stringTokenizer.nextToken();

        int mostMatchCount = Integer.MIN_VALUE;
        int diffLength = B.length() - A.length();
        for (int i=0 ; i<=diffLength ; i++) {
            int matchCount = 0;
            for (int j=0 ; j<A.length() ; j++) {
                char aChar = A.charAt(j);
                char bChar = B.charAt(j + i);
                if (aChar == bChar) {
                    matchCount++;
                }
            }
            if (mostMatchCount < matchCount) {
                mostMatchCount = matchCount;
            }
        }
        System.out.println(A.length() - mostMatchCount);
    }
}