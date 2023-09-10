class Solution {
    public int solution(int[] numbers, int k) {
        int answer = 0;
        for (int i = 0; i < k; i++) {
            answer = numbers[(2 * i) % numbers.length];
        }
        return answer;
    }
}