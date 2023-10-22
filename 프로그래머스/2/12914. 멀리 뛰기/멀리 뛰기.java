class Solution {
    long[] dp;
    
    long fibo(int n) {
        if (n == 1 || n == 2) return dp[n];
        
        if (n > 2 && dp[n] == 0) {
            return dp[n] = (fibo(n - 1) + fibo(n - 2)) % 1234567;
        } else {
            return dp[n];    
        }
    }
    
    public long solution(int n) {
        dp = new long[n + 1];
        
        if (n == 1) return 1;
        
        dp[1] = 1;
        dp[2] = 2;
        
        fibo(n);
        
        return dp[n];
    }
}