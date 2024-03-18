class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int[][] dp = new int[n][m];
        
        dp[0][0] = 1; // 출발 위치
        
        for (int i = 0; i < n; i++) {
            Outer: for (int j = 0; j < m; j++) {
                if (i == 0 && j == 0) continue;
                for (int idx = 0; idx < puddles.length; idx++) {
                    if (i == puddles[idx][1] - 1 && j == puddles[idx][0] - 1) continue Outer;
                }
                
                if (i == 0) {
                    dp[i][j] = dp[i][j - 1];
                } else if (j == 0) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % 1000000007;
                }
            }
        }
        
        return dp[n - 1][m - 1];
    }
}