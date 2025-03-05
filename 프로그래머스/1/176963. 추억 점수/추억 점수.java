import java.util.HashMap;


class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];
        HashMap<String, Integer> s = new HashMap<>();


        for (int i=0 ; i<name.length ;i++) {
            s.put(name[i], yearning[i]);
        }

        for (int i=0 ; i<photo.length; i++ ) {
            String[] ps = photo[i];
            int sum=0;
            for (int j=0 ; j<ps.length ; j++) {
                String p = ps[j];
                sum += s.getOrDefault(p, 0);
            }
            answer[i] = sum;
        }

        return answer;
    }
}