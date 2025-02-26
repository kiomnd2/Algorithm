class Solution {
    public int solution(int[] numbers) {
        int[] arr = new int[10];

        for (int number : numbers) {
            arr[number] = 1;
        }

        int sum = 0;
        for (int i=0 ;i< arr.length ; i++) {
            if (arr[i] == 0) {
                sum += i;
            }
        }


        return sum;
    }
}