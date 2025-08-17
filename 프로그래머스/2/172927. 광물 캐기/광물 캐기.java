import java.util.Arrays;

class Solution {
    
public int solution(int[] picks, String[] minerals) {
    // 총 곡괭이 개수
    int totalPicks = picks[0] + picks[1] + picks[2];
    
    // 실제로 캘 수 있는 광물 개수 (곡괭이 개수 * 5 vs 전체 광물 개수)
    int maxMinerals = Math.min(totalPicks * 5, minerals.length);
    
    // 5개씩 그룹으로 나눈 그룹 개수
    int groups = (maxMinerals + 4) / 5; // 올림 계산
    
    // 각 그룹별 피로도 저장
    int[][] costs = new int[groups][3];
    
    for (int i = 0; i < groups; i++) {
        int[] cost = new int[3]; // [다이아 곡괭이, 철 곡괭이, 돌 곡괭이]
        
        // 각 그룹의 시작 인덱스와 끝 인덱스
        int start = i * 5;
        int end = Math.min(start + 5, maxMinerals);
        
        for (int j = start; j < end; j++) {
            String mineral = minerals[j];
            
            if (mineral.equals("diamond")) {
                cost[0] += 1;  // 다이아 곡괭이
                cost[1] += 5;  // 철 곡괭이
                cost[2] += 25; // 돌 곡괭이
            } else if (mineral.equals("iron")) {
                cost[0] += 1;  // 다이아 곡괭이
                cost[1] += 1;  // 철 곡괭이
                cost[2] += 5;  // 돌 곡괭이
            } else if (mineral.equals("stone")) {
                cost[0] += 1;  // 다이아 곡괭이
                cost[1] += 1;  // 철 곡괭이
                cost[2] += 1;  // 돌 곡괭이
            }
        }
        costs[i] = cost;
    }
    
    // 돌 곡괭이로 캘 때의 피로도 기준으로 내림차순 정렬
    // (가장 어려운 그룹부터 좋은 곡괭이 할당)
    Arrays.sort(costs, (o1, o2) -> o2[2] - o1[2]);
    
    int totalCost = 0;
    int[] picksCopy = picks.clone(); // 원본 배열 보호
    
    // 정렬된 그룹에 대해 가장 좋은 곡괭이부터 할당
    for (int i = 0; i < groups; i++) {
        if (picksCopy[0] > 0) {        // 다이아 곡괭이 사용
            totalCost += costs[i][0];
            picksCopy[0]--;
        } else if (picksCopy[1] > 0) { // 철 곡괭이 사용
            totalCost += costs[i][1];
            picksCopy[1]--;
        } else if (picksCopy[2] > 0) { // 돌 곡괭이 사용
            totalCost += costs[i][2];
            picksCopy[2]--;
        }
    }
    
    return totalCost;
}
}