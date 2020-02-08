package level1;

public class 큰수만들기 {

    public static void main(String[] args) {

        //4177252841	4	775841
        System.out.println(solution("4177252841",4 ));

        System.out.println(solution("1231234",3 ));
    }

    public static String solution(String number, int k) {
        String answer = "";

        String[] numArr = number.split("");

        char[] tempArr = new char[numArr.length - k];
        for(int i =0; i < numArr.length - k ; i++)
        {
            int max =0 ;
            int tempIdx =0 ;
            int preIdx = 0 ;
            int rmvNum =0 ;
            //4177252841
            for( int j = preIdx ; j <= i+k-rmvNum ; j++ )
            {
                int num = Integer.parseInt(numArr[j]);

                if(max < num)
                {
                    tempIdx = j ;
                    max = num ;
                    preIdx = tempIdx;
                }
            }

            tempArr[i] = Character.forDigit(max,10);
            //해당 인덱스 이전 데이터는 모두 날림
            for(int j = tempIdx ; 0 <= j ; j--)
            {
                numArr[j] = "-1";
                rmvNum++ ;
            }
        }

        answer = String.copyValueOf(tempArr);
/*
        char[] numArr = number.toCharArray();

        for(int i=0 ; i < k ; i ++)
        {

            int max = 0;
            char[] tempArr = new char[numArr.length-1];
            for(int j = 0 ; j < numArr.length; j++)
            {
                int tempNum =0;
                //앞에부분 복사
                System.arraycopy(numArr,0,tempArr,0,j);
                //뒤에부분 복사
                System.arraycopy(numArr ,j+1 ,tempArr , j ,numArr.length-j-1);
                tempNum = Integer.parseInt(String.copyValueOf(tempArr));

                if(tempNum > max)
                {
                    max = tempNum;
                }
            }
            numArr = Integer.toString(max).toCharArray();
        }
        answer = String.copyValueOf(numArr);*/
        return answer;
    }
}
