class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        int[] giftPoint = new int[friends.length];
        int[][] friendPoint = new int[friends.length][friends.length];


        for (int i = 0; i < gifts.length; i++) {
            String gift = gifts[i];
            String[] s = gift.split(" ");
            String sender = s[0];
            String receiver = s[1];

            int senderIdx = 0;
            int receiverIdx = 0;
            for (int j=0 ; j<friends.length ; j++) {
                String friend = friends[j];
                if (sender.equals(friend)) {
                    giftPoint[j] ++;
                    senderIdx= j;
                }
                else if (receiver.equals(friend)) {
                    giftPoint[j] --;
                    receiverIdx= j;
                }
            }
            friendPoint[senderIdx][receiverIdx]++;
        }

        int maxGift = 0;
        for (int i = 0; i < friendPoint.length; i++) {

            int point = 0;
            for (int j = 0; j < friendPoint.length; j++) {
                if (i == j) continue;

                int sendGift = friendPoint[i][j];
                int receiverGift = friendPoint[j][i];

                int sendGiftPoint = giftPoint[i];
                int receiverGiftPoint = giftPoint[j];

                // 선물 주고받은 갯수가 동일 할 때,
                if (sendGift == receiverGift) {
                    // 준사람이 더 많으면
                    if (sendGiftPoint > receiverGiftPoint) {
                        point++;
                    }
                } else if (sendGift > receiverGift) {
                    point++;
                }
            }
            maxGift = Math.max(maxGift, point);
        }
        return maxGift;
    }
}