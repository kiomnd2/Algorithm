public class 가장_긴_펠린드롬 {
    public static void main(String[] args) {
        System.out.println(solution("abb"));

    }
    public static int solution(String s)
    {
        int answer = 0;

        for(int i =0; i < s.length() ; i++)
        {
            //  i = cursor
            //사이즈 현재 i만큼 양옆 검사
            int odd = 0;
            int even = 0;
            boolean oddFlag = true;
            boolean evenFlag = true;
            while(oddFlag || evenFlag)
            {
                //aabaa
                //aa
                //s가 짝수 일 때
                if(oddFlag && i - (even) >= 0 &&  i + ( even + 1) < s.length() && s.charAt(i-even) == s.charAt(i+1+even) )
                {
                    even = even+1;
                }
                else{
                    oddFlag =false;
                }
                //i 가준으로 양 옆이 같다 양 끝이 없거나, 일치하지 않을 때.//
                if(evenFlag && i - (1 + odd) >= 0 &&  i + (1 + odd) < s.length() && s.charAt(i - (1 + odd) ) == s.charAt( i + (1 + odd)))
                {
                    odd = odd +1;
                }
                else {
                    evenFlag =false;
                }
            }
            answer = Math.max(answer , Math.max( even*2 , odd *2 + 1));
        }
        return answer;
    }
}
