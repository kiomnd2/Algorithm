package array;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class 가장_큰_수 {
    public String solution(int[] numbers) {
        StringBuilder answer = new StringBuilder();
        String[] numArr = new String[numbers.length];
        List<String> list = new ArrayList<>();

        int max = -1;
        for (int i=0 ; i<numbers.length ; i++) {
            int number = numbers[i];
            String s = String.valueOf(number);
            numArr[i] = s;
            max = Math.max(s.length(), max);
        }

        for (int i=0 ; i< numArr.length ; i++) {
            StringBuilder s = new StringBuilder(numArr[i]);
            char c = numArr[i].charAt(0);
            if (s.length() < max) {
                s.append(String.valueOf(c).repeat(Math.max(0, max - s.length())));
            }
            s.append(":").append(i);
            list.add(s.toString());
        } 

        list.sort(Comparator.comparingInt(o -> Integer.parseInt(o.toString().split(":")[0])).reversed());

        for (String s : list) {
            int idx = Integer.parseInt(s.split(":")[1]);
            answer.append(numbers[idx]);
        }

        if (answer.charAt(0) == '0')
            return "0";

        return answer.toString();
    }
}
