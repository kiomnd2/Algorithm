class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        int position = 1;

        int[] leftTopping = new int[10001];
        int[] rightTopping = new int[10001];


        leftTopping[topping[0]]++;
        int uniqueLeftTopping = 1;
        int uniqueRightTopping = 0;

        for (int i =1; i < topping.length; i++) {
            if (rightTopping[topping[i]] == 0) {
                uniqueRightTopping++;
            }
            rightTopping[topping[i]]++;
        }

        while (uniqueRightTopping >= uniqueLeftTopping) {
            if (uniqueRightTopping == uniqueLeftTopping) {
                answer++;
            }

            int t = topping[position];
            if (leftTopping[t] == 0) { // unique 하면
                uniqueLeftTopping++;
            }

            leftTopping[t]++;
            rightTopping[t]--;

            if (rightTopping[t] == 0) {
                uniqueRightTopping--;
            }

            position++;
        }


        return answer;
    }
}