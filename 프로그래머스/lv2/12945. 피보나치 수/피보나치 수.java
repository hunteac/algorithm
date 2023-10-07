class Solution {
    // 피보나치 수열 값 저장
    static int[] memo;
    
    // 피보나치 수열 메서드
    static int fibo (int n) {
        if (n >= 2 && memo[n] == 0) {
            memo[n] = fibo(n - 1) + fibo(n - 2); 
        }
        if (memo[n] > 1234567) return memo[n] % 1234567; // 피보나치 수열 수가 1234567 초과면 나머지 구하기
        else return memo[n];
    }
    
    public int solution(int n) {
        memo = new int[n + 1];    
        memo[1] = 1;
        return fibo(n);
    }
}