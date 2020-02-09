package programmers.level2;


public class 프랜즈4블록 {
    public static void main(String[] args) {

//        System.out.println(solution(4,5, new String[]{"CCBDE", "AAADE", "AAABF", "CCBBF"} ));
        System.out.println(solution(8,5, new String[]{"HGNHU", "CRSHV", "UKHVL", "MJHQB", "GSHOT", "MQMJJ", "AGJKK", "QULKK"} ));

    }

    public static int solution(int m, int n, final String[] board) {
        int answer = 0;
        //초기화
        char[][] charBoard = new char[m][n];

        for(int i=0; i < board.length ; i++)
        {
            int l = board[i].length();
            for(int j =0; j< l ; j++)
            {
                charBoard[i][j] = board[i].charAt(j);
            }
        }

        for(int i =0 ; i< m ; i++)
        {
            StringBuilder sb = new StringBuilder();
            for(int j =0; j< n ; j++)
            {
                sb.append(charBoard[i][j]);
            }
            System.out.println(sb);
        }

        int[][] checker = new int[m][n];
        int accPoint =0 ;

        boolean flag = true;
        while(flag) {
            flag = false;
            for (int i = 0; i < m - 1; i++) {
                for (int j = 0; j < n - 1; j++) {
                    //1. window를 만들어 정사각형으로 한줄식 체크해서 정사각형에 모드 같은 문자가 들어잇다면
                    if (charBoard[i][j] != '0' && charBoard[i][j] == charBoard[i][j + 1] &&
                            charBoard[i][j + 1] == charBoard[i + 1][j] &&
                            charBoard[i + 1][j] == charBoard[i + 1][j + 1]) {

                        checker[i][j] = 1;
                        checker[i][j+1] = 1;
                        checker[i+1][j] = 1;
                        checker[i+1][j+1] = 1;


                        flag = true; // 한번이라도 찾은적 있다면?
                    }
                }
            }
            System.out.println("======================================");
            for(int i =0 ; i< m ; i++)
            {
                StringBuilder sb = new StringBuilder();
                for(int j =0; j< n ; j++)
                {
                    sb.append(charBoard[i][j]);
                }
                System.out.println(sb);
            }


            //아래서붙터 가야돼
            for (int i = m - 1; i >= 0; i--)
            {
                for (int j = 0; j < n; j++)
                {
                    if(checker[i][j] == 1 )
                    {
                        charBoard[i][j] ='0';
                    }
                    else // 1이 아니라 딴거야.. 끌어 내릴 수 있는 대상
                    {
                        // 바로 아래가 0이면..
                        if( i != m-1 && charBoard[i+1][j] =='0' )
                        {
                            int c=1;
                            while(i+c != m && charBoard[i+c][j] =='0')
                            {
                                char temp = charBoard[i+c][j];
                                charBoard[i+c][j] = charBoard[i + c-1][j];
                                charBoard[i+c-1][j] = temp;

                                int temp1 = checker[i+c][j];
                                checker[i+c][j] = checker[i + c-1][j];
                                checker[i+c-1][j] = temp1;
                                c++;
                            }
                        }
                    }
//                    if(charBoard[i][j] =='0' && charBoard[i-1][j] != '0')
//                    {
//                        //0인 문자가 나올때 까지 끌어내린다
//                        int c=1 ;
//                        while(charBoard[i-1+c][j] =='0')
//                        {
//                            char temp = charBoard[i-1+c][j];
//                            charBoard[i-1+c][j] = charBoard[i-1 + c-1][j];
//                            charBoard[i-1+c-1][j] = temp;
//                            c++;
//                        }
//                    }

                }

            }

            System.out.println("======================================");
            for(int i =0 ; i< m ; i++)
            {
                StringBuilder sb = new StringBuilder();
                for(int j =0; j< n ; j++)
                {
                    sb.append(charBoard[i][j]);
                }
                System.out.println(sb);
            }
        }
        for(int i =0 ; i< m ; i++)
        {
            for(int j=0 ; j< n ; j++)
            {
                if(charBoard[i][j] == '0') {
                    answer++;
                }
            }
        }

        return answer;

    }
}
