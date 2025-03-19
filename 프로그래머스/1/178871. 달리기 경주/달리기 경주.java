
import java.util.HashMap;


class Solution {
    public String[] solution(String[] players, String[] callings) {
        HashMap<String, Integer> map = new HashMap<>();

        int index = 0;
        for (String player : players) {
            map.put(player, index++);
        }

        for (int i=0 ; i<callings.length ; i++) {
            String calling = callings[i];
            Integer ci = map.get(calling);
            int target = ci - 1;

            String targetPlayer = players[target];
            players[ci] = players[target];
            players[target] = calling;

            map.put(calling, target);
            map.put(targetPlayer, ci);
        }

        return players;
    }
}