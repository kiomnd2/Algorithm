class Solution {
      public int solution(int[][] land) {
        int rows = land.length;
        int cols = land[0].length;
        
        // dp[i][j] = i행 j열을 선택했을 때의 최대 점수
        int[][] dp = new int[rows][cols];
        
        // 첫 번째 행 초기화
        for (int j = 0; j < cols; j++) {
            dp[0][j] = land[0][j];
        }
        
        // 각 행에 대해 최대값 계산
        for (int i = 1; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // 이전 행에서 같은 열이 아닌 곳의 최대값 찾기
                for (int k = 0; k < cols; k++) {
                    if (k != j) {
                        dp[i][j] = Math.max(dp[i][j], dp[i-1][k] + land[i][j]);
                    }
                }
            }
        }
        
        // 마지막 행에서 최대값 반환
        int answer = 0;
        for (int j = 0; j < cols; j++) {
            answer = Math.max(answer, dp[rows-1][j]);
        }
        
        return answer;
    }
}