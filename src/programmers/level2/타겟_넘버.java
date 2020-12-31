import java.util.ArrayList;


public class 타겟_넘버 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{1,1,1,1,1}, 3));
    }

    public static int solution(int[] numbers, int target) {
        int answer = 0;


        // 최초값 +

        ArrayList<Integer> list = new ArrayList<>();
        recursive(numbers, 0, 0, list);

        return (int)list.stream().filter(i -> i == target).count();
    }

    public static void recursive(int[] numbers, int curIdx, int sum, ArrayList<Integer> list) {
        // 현재 인덱스와 numbers 의 길이가 같을 때 리턴

        if(numbers.length != curIdx) {
            int number = numbers[curIdx];
            int s = sum +number;
            recursive(numbers, curIdx + 1, s, list);

            int s2 = sum -number;
            recursive(numbers, curIdx + 1 , s2, list);
        } else {
            list.add(sum);
        }

    }

}
