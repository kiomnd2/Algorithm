class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = 0;

        int maxHealth = health;
        int curTime = 1;
        int healLeft = bandage[0];
        int healPerSecond = bandage[1];
        int heal = bandage[2];

        int conj = 0;
        for (int i = 0; i < attacks.length; i++) {
            int time = attacks[i][0];
            int dmg = attacks[i][1];

            for (; curTime<= time ; curTime++) {
                conj ++;
                if (curTime == time) {
                    health -= dmg;
                    conj = 0;
                    if (health <= 0) return -1;
                } else {
                    if (conj == healLeft) {
                        health += heal;
                        health += healPerSecond;
                        conj = 0;
                    } else if (conj > 0) {
                        health += healPerSecond;
                    }

                    if (health > maxHealth) {
                        health = maxHealth;
                    }
                }
            }
            // 끝나는 순간 데미지 연속 성공 초기화
        }

        return health <= 0 ? -1 : health;
    }
}