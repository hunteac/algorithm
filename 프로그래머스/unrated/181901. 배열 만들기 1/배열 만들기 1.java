class Solution {
    public int[] solution(int n, int k) {
        int[] answer = new int[n / k];
        int idx = 0;
        for (int i = 1; i <= n; i++) {
            if (i % k == 0) answer[idx++] = i; // 배수 저장
        }
        return answer;
    }
}