import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class 전화번호_목록 {
    public static void main(String[] args) {

        System.out.println(solution(new String[]{"123", "456", "789"}));
    }

    public static boolean solution(String[] phone_book) {
        boolean answer = true;

        /**
         * [119, 97674223, 1195524421]	false
         * [123,456,789]	true
         * [12,123,1235,567,88]	false
         */

/*
        Arrays.sort(phone_book);

        if (phone_book[1].startsWith(phone_book[0])) {
            return false;
        }
*/

        HashSet<String> set = new HashSet<>();
        for (String book : phone_book) {
            set.add(book);

            Iterator<String> iterator = set.iterator();
            while(iterator.hasNext()) {
                String next = iterator.next();

                if (!iterator.hasNext() && book.length() < next.length() && next.startsWith(book)) { // 마지막일 경우
                    return false;
                }
                if (next.length() < book.length() && book.startsWith(next)) {
                    return false;
                }
            }

        }

        return true;
    }
}
