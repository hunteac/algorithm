class Solution {
    public int solution(int[] numbers) {
        int answer = 0;
        int[] count = new int[10];
        for (int i = 0; i < numbers.length; i++) {
            count[numbers[i]]++;
        }
        for (int i = 0; i < count.length; i++) {
            if (count[i] == 0) answer += i;
        }
        return answer;
    }
}