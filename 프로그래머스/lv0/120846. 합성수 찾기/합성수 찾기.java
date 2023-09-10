class Solution {
    public int solution(int n) {
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            int cnt = 0;
            for (int j = 1; j <= i; j++) { // 약수 개수 구하기
                if (i % j == 0) cnt++;
            }
            if (cnt >= 3) answer++; // 약수 개수가 3개 이상인 수
        }
        return answer;
    }
}