import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        int[] dist = new int[n+1];

        for (int i = 0; i<n+1 ; i++) {
            graph.add(i, new ArrayList<>());
        }

        for (int i = 0; i<edge.length ; i++) {
            int x = edge[i][0];
            int y = edge[i][1];
            graph.get(x).add(y);
            graph.get(y).add(x);
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        boolean[] visited = new boolean[n+1];
        visited[1] = true;

        while (!queue.isEmpty()) {
            Integer node = queue.poll();

            ArrayList<Integer> nodeList = graph.get(node);
            for (int i = 0; i < nodeList.size(); i++) {
                if (!visited[nodeList.get(i)]) {
                    queue.add(nodeList.get(i));
                    visited[nodeList.get(i)] = true;
                    dist[nodeList.get(i)] = dist[node] + 1;
                }
            }
        }

        Arrays.sort(dist);
        int max = dist[dist.length-1];
        int count = 1;
        for (int d : dist) {
            System.out.println("d = " + d);
        }

        for (int i = dist.length -2 ; i>=0; i--) {
            if ( max == dist[i]) {
                count++;
            } else {
                break;
            }
        }

        return count;
    }
}