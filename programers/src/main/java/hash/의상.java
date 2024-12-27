package hash;

import java.util.HashMap;

public class 의상 {

    public int solution(String[][] clothes) {
        HashMap<String, Integer> clothesHash = new HashMap<>();

        int count=0;
        for (String[] clothe : clothes) {

            String clotheType = clothe[1];

            if (!clothesHash.containsKey(clotheType)) {
                clothesHash.put(clotheType, 1);
            } else {
                Integer i = clothesHash.get(clotheType);
                clothesHash.put(clotheType, i+1);
            }
        }

        int acc = 1;
        for (String clothe : clothesHash.keySet()) {
            int i = clothesHash.get(clothe)+1;
            acc *= i;
        }

        // 모두 안입는 수
        acc = acc -1;

        return acc;
    }
}
