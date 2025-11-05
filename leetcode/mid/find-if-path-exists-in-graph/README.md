## find-if-path-exists-in-graph
https://leetcode.com/problems/find-if-path-exists-in-graph/description/
### 문제 요약
* 간선 갯수 n
* 방향이 없는 간선정보 int[][] edge
* 시작 점 source
* 끝점 destination
* 위 네개의 정보가 주어짐
* 간선을 따라가서 source 에서 destination 까지 도달하는지 여부를 리턴

### 풀이 요약
* 간선정보를 그래프로 저장
* 그래프를 bfs 로 순회, 목적지에 도달하면 true 아니면 false 리턴


```java


    public boolean validPath(int n, int[][] edges, int source, int destination) {
        if (n == 1) return true;

        boolean[] visit = new boolean[n];
        int[][] graph = new int[n][n];

        for (int i =0 ; i < edges.length ; i++) {
            int x = edges[i][0];
            int y = edges[i][1];
            graph[x][y] = 1;
            graph[y][x] = 1;
        }

        Queue<Integer> q = new LinkedList<>();
        q.add(source);
        visit[source] = true;

        while (!q.isEmpty()) {
            Integer poll = q.poll();
            int[] toEdge = graph[poll];

            for (int i = 0; i < toEdge.length; i++) {
                if (toEdge[i] == 1 && !visit[i]) {
                    if (i == destination) {
                        return true;
                    }
                    visit[i] = true;
                    q.add(i);
                }
            }
        }

        return false;
    }
```
* 위와 같이 풀었을 경우 시간초과 발생,,