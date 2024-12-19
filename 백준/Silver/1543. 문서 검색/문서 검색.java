import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String text = br.readLine();
        String word = br.readLine();

        int currentIdx = 0;
        int wordLength = word.length();
        int resultCount = 0;
        while (currentIdx <= text.length()) {
            if (currentIdx + wordLength > text.length()) break;

            String leftText = text.substring(currentIdx, currentIdx + wordLength);
            if (leftText.equals(word)) {
                currentIdx += wordLength;
                resultCount++;
            } else {
                currentIdx++;
            }
        }
        System.out.println(resultCount);
    }
}