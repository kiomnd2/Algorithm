package level1.dfs;


public class 타겟_넘버 {
    int answer = 0;

    public int solution(int[] numbers, int target) {

        boolean[] visit = new boolean[numbers.length];
        dfs(visit, numbers, 0, 0, target);

        return answer;
    }

    public void dfs(boolean[] visit, int[] numbers, int curIdx, int acc, int target) {
        if (curIdx >= visit.length) {
            return;
        }

        if (visit.length-1 == curIdx && target == acc) {
            answer ++;
        }

        dfs(visit, numbers, curIdx+1, acc + numbers[curIdx], target);
        dfs(visit, numbers, curIdx+1, acc - numbers[curIdx], target);
    }
}
