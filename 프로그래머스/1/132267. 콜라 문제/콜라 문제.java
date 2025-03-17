class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;

        int coke = 0;
        int leftCoke = 0;
        while (n >= a) {
            leftCoke = n%a;
            coke = (n/a)*b;
            answer += coke;
            n = coke + leftCoke;
        }

        return answer;
    }
}