import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int N = Integer.parseInt(br.readLine());

        int[][] rgb = new int[N][3];
        int[][] dp = new int[N][3];
        
        for (int i = 0; i < N; i++) {
        	st = new StringTokenizer(br.readLine());
        	for (int j = 0; j < 3; j++) {
        		rgb[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        
        dp[0][0] = rgb[0][0]; // 빨간색 비용
        dp[0][1] = rgb[0][1]; // 초록색 비용
        dp[0][2] = rgb[0][2]; // 파란색 비용
        
        for (int i = 1; i < N; i++) {
        	// 이전 집 색깔이 빨간색이면 초록색과 파란색 중 더 작은 비용 선택
        	dp[i][0] = Math.min(dp[i - 1][1] + rgb[i][0], dp[i - 1][2] + rgb[i][0]);
        	// 이전 집 색깔이 초록색이면 빨간색과 파란색 중 더 작은 비용 선택
        	dp[i][1] = Math.min(dp[i - 1][0] + rgb[i][1], dp[i - 1][2] + rgb[i][1]);
        	// 이전 집 색깔이 파란색이면 빨간색과 초록색 중 더 작은 비용 선택
        	dp[i][2] = Math.min(dp[i - 1][0] + rgb[i][2], dp[i - 1][1] + rgb[i][2]);
        }
        
        int min = Math.min(dp[N - 1][0], dp[N - 1][1]); // 최종 최솟값 구하기
        min = Math.min(min, dp[N - 1][2]);
        
        System.out.println(min);
    }
}