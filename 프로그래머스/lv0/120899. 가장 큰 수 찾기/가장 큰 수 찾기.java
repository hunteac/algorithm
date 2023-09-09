class Solution {
    public int[] solution(int[] array) {
        int[] answer = new int[2];
        int max = -1;
        int idx = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i]; // 최대값 구하기
                idx = i; // 최대값 인덱스 구하기
            }
        }
        answer[0] = max;
        answer[1] = idx;
        return answer;
    }
}