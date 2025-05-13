
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        HashMap<String, List<String>> map = new HashMap<>();
        int[] reported = new int[id_list.length];

        for (int i =0 ; i< id_list.length; i++) {
            String id = id_list[i];
            map.put(id, new ArrayList<>());
        }

        // 신고한사람 키 value
        for (int i = 0; i < report.length; i++) {
            String r = report[i];
            String[] rs = r.split(" ");

            // 신고당한 사람 리스트
            List<String> called = map.get(rs[1]);

           // 없으면 신고
            if (!called.contains(rs[1])) {
                if (!called.contains(rs[0])) called.add(rs[0]);
            }
        }
        
        for (String s : map.keySet()) {
            // 신고당한 수
            int reportedSize = map.get(s).size();
            if (reportedSize >= k) {
                List<String> strings = map.get(s);
                for (String string : strings) {
                    for (int i = 0; i < id_list.length; i++) {
                        if (string.equals(id_list[i])) {
                            answer[i]++;
                        }
                    }
                }
            }
        }
    
        return answer;
    }
}