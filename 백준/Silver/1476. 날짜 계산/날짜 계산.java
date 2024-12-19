import java.util.Scanner;

public class Main {

    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);

        int E = sc.nextInt(); // ~ 15
        int S = sc.nextInt(); // ~ 28
        int M = sc.nextInt(); // ~ 19

        int index=1;
        int e=1;
        int s=1;
        int m=1;

        while (true) {

            if (E==e && S == s && M == m) {
                break;
            }

            index ++;
            e++;
            s++;
            m++;
            if (e > 15) e = 1;
            if (s > 28) s = 1;
            if (m > 19) m = 1;
        }
        System.out.println(index);
    }
}