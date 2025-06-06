import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] prices = new int[N + 1];
        int[] dp = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i++) prices[i] = Integer.parseInt(st.nextToken());

        dp[1] = prices[1];

        for (int i = 2; i <= N; i++) {
            for (int j = 1; j <= i; j++) {
                if (i != j) dp[i] = Math.max(dp[i], dp[j] + prices[i - j]);
                else dp[i] = Math.max(dp[i], prices[i]);
            }
        }

        System.out.println(dp[N]);
    }
}