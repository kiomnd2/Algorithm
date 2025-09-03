class Solution {
    public int solution(int left, int right) {
        int sum =0;
        for (int i = left; i <= right; i++) {
            int measure = measureCount(i);
            if (measure % 2 ==0) { // 짝수
                sum += i;
            } else {
                sum -= i;
            }
        }
        return sum;
    }

    public int measureCount(int n) {
        if (n == 1) return 1;
        int div = 2;
        int count = 2;
        for (int i = 2; i < n/2+1 ; i++) {
            if (n % i == 0) {
                count ++;
            }
        }
        return count;
    }
}