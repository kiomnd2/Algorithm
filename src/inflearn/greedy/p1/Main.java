package greedy.p1;

import javax.print.attribute.standard.Compression;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.Collectors;


public class Main {

    class Node implements Comparable<Node> {

        public int x,y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Node o) {
            return o.x - this.x;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }
    // 씨름선수
    public int solution() {
        int answer = 0;


        Scanner in=new Scanner(System.in);
        int inputN = in.nextInt();

        ArrayList<Node> list = new ArrayList<>();

        for (int i=0 ; i< inputN; i++) {
            int i1 = in.nextInt();
            int i2 = in.nextInt();
            list.add(new Node(i1, i2));
        }
        Collections.sort(list);

        ArrayList<Node> r = new ArrayList<>();
        r.add(list.get(0));
        int max = Integer.MIN_VALUE;

        int cnt=0;
        for (Node ob : list) {
            if (ob.y > max) {
                max = ob.y;
                cnt ++;
            }
        }

        answer = cnt;
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(new Main().solution());
    }
}
