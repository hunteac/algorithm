class Solution {
    public int solution(int left, int right) {
        int answer = 0;
        int cnt = 0;
        int n = 1;
        for (int i = left; i <= right; i++) {
            n = 1;
            cnt = 0;
            while (n <= i) {
                if (i % n == 0) cnt++; // 약수 개수 구하기
                n++;
            }
            if (cnt % 2 == 0) answer += i; // 약수 개수 짝수면 더하기
            else answer -= i; // 약수 개수 홀수면 빼기
        }
        return answer;
    }
}