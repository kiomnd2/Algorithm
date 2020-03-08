import java.util.ArrayList;
import java.util.List;

public class 같은_숫자는_싫어 {
    public static void main(String[] args) {
        int[] answer = {1,1,3,3,0,1,1};
        int[] result = solution(answer);

        for( int i=0 ; i< result.length ; i++)
        {
            System.out.println(result[i]);
        }

    }
    public static int[] solution(int []arr) {
        int[] answer = {};

        List<Integer> res = new ArrayList<Integer>();
        //arr = [1, 1, 3, 3, 0, 1, 1] 이면 [1, 3, 0, 1] 을 return 합니다.
        //arr = [4, 4, 4, 3, 3] 이면 [4, 3] 을 return 합니다.
        res.add(arr[0]);
        for (int i = 1; i < arr.length; i++)
        {

            if( arr[i-1] != arr[i] )
            {
                res.add(arr[i]);
            }
        }

        answer = new int[res.size()];
        for(int i =0; i < res.size() ; i++)
        {
            answer[i] = res.get(i);
        }

        return answer;
    }
}
