public class 문자열_압축 {
    public static void main(String[] args) {
        System.out.println(solution("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"));

    }
    public static int solution(String s) {
        int answer = 0;
        //"aabbaccc"	7
        //"ababcdcdababcdcd"	9
        //"abcabcdede"	8
        //"abcabcabcabcdededededede"	4abc6de 14
        //"xababcdcdababcdcd"	17

        char[] arr = s.toCharArray();
        int cut = 1;
        int max =0;

        while (arr.length > cut) {
            int preMax =0;
            int cuted =0 ;
            int acc=0;
            boolean eq = true;
            int aCnt = 1;
            for(int i=cut ; i< arr.length; i++)
            {
                //잘라서 맨처음거 제외하고 다음것부터 검사할때
                //맨앞과 일치하는지 확인
                if(arr[i-cut] != arr[i])
                {
                    eq=false;
                }
                cuted++;

                //자르고자하는 횟수와 자를 횟수가 일치
                if(cuted == cut)
                {
                    //자른 횟수 초기화
                    cuted=0;

                    if(eq) //앞,뒤 단어가 같은 단어라고 판별
                    {
                        preMax+=cut;
                        aCnt++;
                    }
                    else
                    {
                        //기존에 누적되어잇던 단어들이 있다면
                        if(aCnt >1)
                        {
                            acc += Integer.toString(aCnt).length();
                        }
                        aCnt=1;
                    }

                    eq=true;
                }
                if(i == arr.length-1) // 마지막 문자야
                {
                    if(aCnt>1)
                    {
                        acc += Integer.toString(aCnt).length();
                    }
                }

                /*if(cuted == cut && eq)
                {
                    preMax = preMax + cut;
                    cuted=0;
                    eq=true;
                    aCnt++;
                    if(i == arr.length -1) // 마지막 인텍스 까지 왔을때
                    {
                        aa-=Integer.toString(aCnt).length();
                        aa+=preMax;
                        preMax=0;
                    }

                }
                else if(cuted == cut  ) // 자른횟수는 일치하는데 eq가 false면 자른횟수를 다시 0으로 초기화 eq를 true로 다시
                {
                    eq=true;
                    cuted =0;
                    if(preMax>0) // 다른데 기존에 누적된 값이 있었다면
                    {
                        aa-=Integer.toString(aCnt).length();
                        aa+=preMax;
                        aCnt=1;
                        preMax=0;
                    }
                }*/
            }

            int temp = preMax-acc;
            System.out.println("preMAx : " + preMax + " acc : "+acc + " temp : " + temp);
            preMax -= acc;

            if(preMax > max)
            {
                max = preMax;
            }
            cut++; //자르는 갯수를 하나씩 늘림
        }
        answer = arr.length - max;
        return answer;
    }
}
