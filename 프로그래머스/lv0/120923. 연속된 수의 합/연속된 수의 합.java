class Solution {
    public int[] solution(int num, int total) {
        int[] answer = new int[num];
        int idx = 0;
        if (total % num == 0) { // 연속하는 수의 중앙값 == total / num
            for (int i = (total / num) - (num / 2); i <= (total / num) + (num / 2); i++) {
                answer[idx++] = i;
            }
        } else { // 연속하는 수의 중앙값 != total / num
            for (int i = (total / num) - (num / 2 - 1); i <= (total / num) + (num / 2); i++) {
                answer[idx++] = i;
            }
        }
        return answer;
    }
}