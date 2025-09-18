## Minimum Path Sum
https://leetcode.com/problems/minimum-path-sum/

### 문제 요약
* M x N 의 배열이 주어지며 배열의 값으로는 음수가아닌 숫자가 입력됨
* 각 배열을 따라서 0, 0 에서 M-1, N-1 까지 이동하면서 해당 배열의 값을 더했을 때, 최소값이 되는 수를 찾기

### 풀이 요약
* 최초 dfs 를 활용
* 0,0 에서 m-1, n-1 로 이동하되 최소 거리를 이동할 minDist 를 만들어 최소 이동경로를 배열에 더해가면서 이동
* 최종적으로 포지션이 m-1, n-1 으로 이동했을 때 dfs 재귀를 멈추고 해당값을 최소값으로 입력 (반복)
* 결과적으로 dfs 로 풀었을 때 시간초과가 발생했음
* 다시 bfs 를 활용하여 풀었으며, bfs 로 풀었을 때 정답


#### dfs 풀이
```java
public int minPathSumDfs(int[][] grid) {
    int answer = 0;

    int[][] visit = new int[grid.length][grid[0].length];

    for (int i = 0; i < grid.length; i++) {
        for (int j = 0; j < grid[0].length; j++) {
            visit[i][j] = Integer.MAX_VALUE;
        }
    }
    visit[0][0] = grid[0][0];
    dfs(grid, visit, 0, 0, grid[0][0]);

    return minValue;
}
int minValue = Integer.MAX_VALUE;

public void dfs(int[][] grid, int[][] visit, int x, int y, int sumNumber) {
    if (x == grid.length - 1 && y == grid[0].length - 1) {
        minValue = Math.min(minValue, sumNumber);
        return;
    }

    int[] dirX = {0, 1};
    int[] dirY = {1, 0};

    for (int i = 0; i < 2; i++) {
        int moveX = x + dirX[i];
        int moveY = y + dirY[i];

        if (moveX < grid.length && moveY < grid[0].length) {
            if (visit[moveX][moveY] >= grid[moveX][moveY]) {
                visit[moveX][moveY] = grid[moveX][moveY];
                dfs(grid, visit, moveX, moveY, sumNumber + grid[moveX][moveY]);
            }

        }
    }
}
```

#### bfs 풀이
```java
public int minPathSumBfs(int[][] grid) {
    int rows = grid.length;
    int cols = grid[0].length;

    // 최소 거리를 저장할 배열
    int[][] minDist = new int[rows][cols];

    // 초기화
    for (int i = 0; i < rows; i++) {
        for (int j = 0; j < cols; j++) {
            minDist[i][j] = Integer.MAX_VALUE;
        }
    }

    // BFS를 위한 큐
    Queue<int[]> queue = new LinkedList<>();

    // 시작점 설정
    minDist[0][0] = grid[0][0];
    queue.offer(new int[]{0, 0, grid[0][0]}); // {x, y, currentSum}

    // 이동 방향 (오른쪽, 아래)
    int[] dirX = {0, 1};
    int[] dirY = {1, 0};

    while (!queue.isEmpty()) {
        int[] current = queue.poll();
        int x = current[0];
        int y = current[1];
        int currentSum = current[2];

        // 현재 위치까지의 최소 합보다 큰 경우 스킵
        if (currentSum > minDist[x][y]) {
            continue;
        }

        // 4방향 탐색 (여기서는 오른쪽, 아래만)
        for (int i = 0; i < 2; i++) {
            int moveX = x + dirX[i];
            int moveY = y + dirY[i];

            // 경계 체크
            if (moveX < rows && moveY < cols) {
                int newSum = currentSum + grid[moveX][moveY];

                // 더 짧은 경로를 발견한 경우
                if (newSum < minDist[moveX][moveY]) {
                    minDist[moveX][moveY] = newSum;
                    queue.offer(new int[]{moveX, moveY, newSum});
                }
            }
        }
    }

    return minDist[rows - 1][cols - 1];
}
```