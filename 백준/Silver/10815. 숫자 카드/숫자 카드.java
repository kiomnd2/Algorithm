import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] minusArr = new int[10000000];
        int[] plusArr = new int[10000000];

        for (int i=0 ; i< N ; i++) {
            int num = scanner.nextInt();
            if (num < 0) {
                minusArr[-num] = 1;
            } else {
                plusArr[num] =1;
            }
        }

        int M = scanner.nextInt();
        int[] resultArr = new int[M];
        for (int i=0 ; i < M ; i++) {
            int _num = scanner.nextInt();
            if (_num < 0) {
                int i1 = minusArr[-_num];
                resultArr[i] = i1;
            } else {
                int i1 = plusArr[_num];
                resultArr[i] = i1;
            }
        }
        for (int i=0 ; i<resultArr.length ; i++) {
            if (i == resultArr.length-1) {
                System.out.print(resultArr[i]);
            } else {
                System.out.print(resultArr[i] + " ");
            }
        }
    }
}
