import java.util.HashSet;
import java.util.Set;
class Solution {
    public static int solution(int[] schedules, int[][] timelogs, int startday) {
        // startday 감소
        startday -= 1;

        // 주말 체크 방지 (0-based index)
        Set<Integer> notCheck = new HashSet<>();
        notCheck.add(5); // Saturday
        notCheck.add(6); // Sunday

        // 지각한 직원들을 저장할 Set
        Set<Integer> checkedEmp = new HashSet<>();

        // 일주일 동안 순회
        for (int i = 0; i < 7; i++) {
            // 오늘 요일 계산
            int nowday = (startday + i) % 7;

            // 주말이면 건너뛰기
            if (notCheck.contains(nowday)) {
                continue;
            }

            // 직원 순회
            for (int j = 0; j < schedules.length; j++) {
                // 목표 출근 시간 (허용 지각 10분 추가)
                int schedule = timeToMin(schedules[j]) + 10;

                // 직원의 오늘 출근 시간
                int timelog = timeToMin(timelogs[j][i]);

                // 지각했는지 확인
                if (timelog > schedule) {
                    checkedEmp.add(j);
                }
            }
        }

        // 전체 직원 수에서 지각한 직원 수를 뺀 값 반환
        return schedules.length - checkedEmp.size();
    }

    public static int timeToMin(int timeValue) {
        int hour = timeValue / 100;
        int minute = timeValue % 100;
        return hour * 60 + minute;
    }
}