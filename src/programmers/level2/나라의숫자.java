package programmers.level2;

public class 나라의숫자 {
    public static void main(String[] args) {
        System.out.println(solution(27));

    }

    public static String solution(int n) {
        String answer="";



        //1	1	 || 6	14
        //2	2	 || 7	21
        //3	4	 || 8	22
        //4	11	 || 9	24
        //5	12	 || 10	41

        while(n != 0 )
        {
            // 3으로 나누어 떨어지는경우
            if( n %3 == 0)
            {
                //앞에서 부터 4 가들어감
                answer = "4".concat(answer);
                n = n/3 -1;
            }
            else
            {
                answer = Integer.toString(n%3).concat(answer);
                n = n/3 ;
            }
            // 3으로 나누어 떨어지지 않는경우
        }
        return answer;
    }

}
