package programmers.level2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class 위장 {

    public static void main(String[] args) {

//        System.out.println(solution( new String[][]{{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, { "green_turban", "headgear" }} ));
        System.out.println(solution( new String[][]{{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, { "green_turban", "headgear" }, { "red_sun" ,"eyewear"} } ));

//        System.out.println(solution( new String[][]{{"yellow_hat", "headgear"}, {"yellow_hat", "headgear"} } ));
//        System.out.println(solution( new String[][] {{"crow_mask", "face"}, {"blue_sunglasses", "face"}, {"smoky_makeup", "face"}} ));

    }
    //[[yellow_hat, headgear], [blue_sunglasses, eyewear], [green_turban, headgear]]	5
    //[[crow_mask, face], [blue_sunglasses, face], [smoky_makeup, face]]	3

    public static int solution(String[][] clothes) {
        int answer = 0;


        Map<String, ArrayList> result = new HashMap<>();



        //먼저 옷 종류별로 int 값을 가짐
        for( int i = 0 ; i < clothes.length ; i++)
        {
            // 옷 종류 마다 종류에 대한 갯수르 가지고 종류의_갯수* 형태로 나옴
            //해당 옷의 종류에대한 키를 이미 가지고 있으면?
            String kindOfClothe = clothes[i][1];
            if(result.containsKey(kindOfClothe))
            {
                //똑같은거 있을 때 처리
                //ArrayList는 중복 허용 안돼니 처리 안해도됌..

                ArrayList<String> clothesList = result.get(kindOfClothe);
                clothesList.add(clothes[i][0]);
//                int num = clothesNum.get(kindOfClothes);
                result.replace(kindOfClothe, clothesList);
            }
            else
            {
                ArrayList<String> kindOfClothes = new ArrayList<>();
                //없을경우 최초
                kindOfClothes.add(clothes[i][0]);
                result.put(clothes[i][1], kindOfClothes);
                System.out.println(result);
            }
        }


        System.out.println(result);



        return answer;
    }
}
