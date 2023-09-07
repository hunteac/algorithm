class Solution {
    public int[] solution(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] *= 2; // 모든 원소들 두배
        }
        return numbers;
    }
}