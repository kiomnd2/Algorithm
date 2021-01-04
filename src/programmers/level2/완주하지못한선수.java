import java.util.HashMap;

public class 완주하지못한선수 {
    public static void main(String[] args) {

//        System.out.println(solution(new String[]{"leo", "kiki", "eden"}, new String[] {"eden", "kiki"}));
        System.out.println(solution(new String[]{"mislav","stanko", "mislav", "ana"}, new String[] {"stanko", "ana", "mislav"}));
    }
    public static String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> map = new HashMap<>();

        for (String s : participant) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }


        for (String s : completion) {
            map.put(s, map.get(s) -1);
            if (map.get(s) == 0) {
                System.out.println(map.get(s));
            }
        }

        System.out.println(map);
        return map.keySet().iterator().next();
    }

}
