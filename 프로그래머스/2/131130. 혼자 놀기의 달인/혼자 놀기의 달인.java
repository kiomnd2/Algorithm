import java.util.*;

class Solution {
    public int solution(int[] cards) {

        boolean[] visit =  new boolean[cards.length];
        Queue<Integer> queue = new LinkedList<>();
        ArrayList<Integer> boxCountList = new ArrayList<>();
        for (int i =0; i < cards.length; i++) {
            if (!visit[i]) {
                visit[i] = true;
                int count = 1;
                queue.add(i);

                while (!queue.isEmpty()) {
                    Integer idx = queue.poll();

                    int cardIdx = cards[idx]-1;
                    if (!visit[cardIdx]) {
                        visit[cardIdx] = true;
                        count++;
                        queue.add(cardIdx);
                    }

                }
                boxCountList.add(count);
            }
        }
        if (boxCountList.size() <= 1) {
            return 0;
        } else {
            Collections.sort(boxCountList, Collections.reverseOrder());
            return boxCountList.get(0) * boxCountList.get(1);
        }
    }
}