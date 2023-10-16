class Solution {  
    public int solution(int[][] triangle) {
        int answer = 0; // 최댓값
        
        int N = triangle.length; // 삼각형 길이
        
        int[][] dp = new int[N][N];
        
        dp[0][0] = triangle[0][0]; // 초기값
        
        // 동적계획법
        for (int i = 1; i < N; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0) dp[i][j] = dp[i - 1][j] + triangle[i][j]; // 왼쪽
                else if (j == N - 1) dp[i][j] = dp[i - 1][j] + triangle[i][j]; // 오른쪽
                else dp[i][j] = Math.max(dp[i - 1][j - 1] + triangle[i][j], dp[i - 1][j] + triangle[i][j]); // 중앙: 왼쪽과 오른쪽을 비교하여 더 큰 값으로 갱신
                
                // 맨 아래 도착시 최댓값 갱신
                if (i == N - 1) answer = Math.max(answer, dp[i][j]);
            }
        }
        
        return answer;
    }    
}