import java.util.*;

public class 완주하지_못한_선수 {
    public static void main(String[] args) {

        //[leo, kiki, eden]	[eden, kiki]	leo
        //[marina, josipa, nikola, vinko, filipa]	[josipa, filipa, marina, nikola]	vinko
        //[mislav, stanko, mislav, ana]	[stanko, ana, mislav]	mislav

        System.out.println(solution(new String[]{"mislav","stanko","mislav","ana"}, new String[]{"stanko","ana", "mislav"}));

    }

    public static String solution(String[] participant, String[] completion) {

        HashMap<String, Integer> map = new HashMap<>();


        for (int i =0 ; i< participant.length; i++ ) {
            map.put(participant[i], map.getOrDefault(participant[i], 0) + 1);
        }


        for (int i =0 ; i< completion.length; i++ ) {
            if (map.containsKey(completion[i])){
                map.put(completion[i], map.get(completion[i])-1);
            }
        }



        return map.keySet().iterator().next();
    }
}
