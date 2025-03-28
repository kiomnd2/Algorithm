import java.util.*;


class Solution {
    
    public String solution(String X, String Y) {
        StringBuilder result = new StringBuilder();

        int[] xArr = new int[10];
        int[] yArr = new int[10];

        for (String x : X.split("")) {
            xArr[Integer.parseInt(x)]++;
        }

        for (String y : Y.split("")) {
            yArr[Integer.parseInt(y)]++;
        }

        boolean visit = false;
        int sum = 0;
        for (int i = xArr.length -1 ; i >= 0; i--) {
            if (xArr[i] > 0 && yArr[i] > 0) {
                int min = Math.min(xArr[i], yArr[i]);

                for (int j = 0 ; j < min ; j++) {
                    result.append(i);
                    visit = true;
                    sum += i;
                }
            }
        }

        if (!visit) return "-1";
        if (sum == 0) return "0";

        return result.toString();
    }
}