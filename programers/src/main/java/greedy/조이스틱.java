package greedy;

public class 조이스틱 {
    public int solution(String name) {
        char[] alp = name.toCharArray();

        int move = name.length()-1;
        int count=0;
        for (int i=0 ; i<name.length() ; i++) {
                int diffLager = 90 - alp[i];
            int diffSmaller = alp[i] - 65;

            if (diffSmaller <= diffLager) {
                count += diffSmaller;
            } else {
                // 반대로 가는건 역방향으로 한번 더 가야함
                count += diffLager + 1;
            }

            int idx = i+1;
            while (idx < name.length() && name.charAt(idx) == 'A') {
                idx++; //
            }

            move = Math.min(move, i*2 + name.length() - idx);
            move = Math.min(move, (name.length() - idx)*2 + i);
        }

        return count + move;
    }

}
