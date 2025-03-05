package ch;

import java.util.HashSet;
import java.util.Set;

public class 유연근무제 {
    public static void main(String[] args) {
        /*int[] schedules = {700, 800, 1100};
        int[][] timelogs = {{710, 2359, 1050, 700, 650, 631, 659}
        , {800, 801, 805, 800, 759, 810, 809}
        , {1105, 1001, 1002, 600, 1059, 1001, 1100}};

        int startDays = 5;
*/

        int[] schedules = {730, 855, 700, 720};
        int[][] timelogs = {{710, 700, 650, 735, 700, 931, 912}, {908, 901, 805, 815, 800, 831, 835}, {705, 701, 702, 705, 710, 710, 711}, {707, 731, 859, 913, 934, 931, 905}};
        int startDays = 1;

        int solution = new 유연근무제().solution(schedules, timelogs, startDays);
        System.out.println("solution = " + solution);

    }

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
