class Solution {
    public int[] solution(int n) {
        int[] answer = new int[(n + 1) / 2];
        int idx = 0;
        for (int i = 1; i <= n; i += 2) {
            answer[idx++] += i; // n 이하의 홀수 담기
        }
        return answer;
    }
}