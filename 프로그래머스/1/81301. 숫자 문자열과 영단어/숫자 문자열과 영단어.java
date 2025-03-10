class Solution {
    public int solution(String s) {
        int answer = 0;
        String[] number = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };

        StringBuilder sb = new StringBuilder();

        while (0 < s.length()) {
            if (s.charAt(0) >= '0' && s.charAt(0) <= '9' ) {
                sb.append(s.charAt(0));
                s = s.substring(1);
            } else {
                for (int i = 0; i < number.length; i++) {
                    if (s.length() >= number[i].length()) {
                        String s1 = s.substring(0, number[i].length());
                        if (s1.contains(number[i])) {
                            sb.append(i);
                            s = s.substring(number[i].length());
                            break;
                        }
                    }
                }
            }

        }

        return Integer.parseInt(sb.toString());
    }
}