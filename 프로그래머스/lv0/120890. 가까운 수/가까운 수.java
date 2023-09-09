class Solution {
    public int solution(int[] array, int n) {
        int minAnswer = 101;
        int min = 100;
        for (int i = 0; i < array.length; i++) {
            if (Math.abs(array[i] - n) < min) min = Math.abs(array[i] - n);
        }
        for (int i = 0; i < array.length; i++) {
            if (min == Math.abs(array[i] - n)) minAnswer = Math.min(minAnswer, array[i]); // 가까운 수가 여러 개일 경우 더 작은 수 반환
        }
        return minAnswer;
    }
}