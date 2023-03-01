import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        boolean[] v = new boolean[n];
        int[] arr = new int[n];

        perm(n, 0, arr, v);
    }

    public static void perm(int n, int depth, int[] arr, boolean[] visit) {

        if (n == depth) {
            StringBuffer sb = new StringBuffer();
            for (int i=0 ; i<arr.length ; i++) {
                sb.append(arr[i]);
                if (i != arr.length-1) {
                    sb.append(" ");
                }
            }
            System.out.println(sb);
            return;
        }

        for (int i=0 ; i < arr.length ; i++) {
            if (!visit[i]) {
                visit[i] = true;
                arr[depth] = i+1;
                perm(n, depth+1, arr, visit);
                visit[i] = false;
            }
        }
    }

}