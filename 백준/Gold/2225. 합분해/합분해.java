import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        int[][] dp = new int[N + 1][K + 1];

        for (int i = 0; i <= N; i++) {
			for (int j = 1; j <= K; j++) {
                if (i == 0 || j == 1) {
                    dp[i][j] = 1;
                    continue;
                }
                
                dp[i][j] = (dp[i][j - 1] + dp[i - 1][j]) % 1000000000;
			}
        }

        System.out.println(dp[N][K]);
    }
}