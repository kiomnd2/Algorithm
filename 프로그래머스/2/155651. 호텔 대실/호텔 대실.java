import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
class Solution {
    public int solution(String[][] book_time) {
        Queue<Node> queue = new PriorityQueue<>();
        for (String[] strings : book_time) {
            queue.add(new Node(strings[0], strings[1]));
        }

        List<Node> nodes = new ArrayList<>();
        while (!queue.isEmpty()) {
            Node node = queue.poll();

            if (!nodes.isEmpty()) {
                int changeIdx = -1;
                for (int i=0 ; i<nodes.size() ; i++) {
                    Node preNode = nodes.get(i);
                    // 끝났을 때
                    if (preNode.endTime + 10 <= node.startTime) {
                        changeIdx = i;
                        break;
                    }
                }

                if (changeIdx != -1) {
                    nodes.remove(changeIdx);
                    nodes.add(changeIdx, node);
                } else {
                    nodes.add(node);
                }

            } else {
                nodes.add(node);
            }
        }

        return nodes.size();
    }

    static class Node implements Comparable<Node>{
        private int startTime;
        private int endTime;


        public Node(String startTime, String endTime) {
            String[] split = startTime.split(":");
            this.startTime = Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);
            this.endTime = Integer.parseInt(endTime.split(":")[0])
                    * 60 + Integer.parseInt(endTime.split(":")[1]);
        }

        @Override
        public int compareTo(Node o) {
            return this.startTime - o.startTime;
        }
    }
}