class Solution {
    public long solution(int a, int b) {
        long answer = 0;
        int max = Math.max(a, b); // 큰 수 구하기
        int min = Math.min(a, b); // 작은 수 구하기
        for (int i = min; i <= max; i++) {
            answer += i;
        }
        return answer;
    }
}