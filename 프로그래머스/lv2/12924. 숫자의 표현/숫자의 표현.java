class Solution {
    public int solution(int n) {
        int answer = 1; // 방법 개수
        
        for (int i = 1; i <= n / 2; i++) {
            int tmp = 0;
            for (int j = i; j < n; j++) {
                tmp += j; // 연속된 숫자 더하기
                if (tmp == n) { // n 표현 가능
                    answer++;
                    break;
                }
                if (tmp > n) break; // n 표현 불가능
            }
        }
        
        return answer;
    }
}