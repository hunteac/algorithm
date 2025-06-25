import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static final int INF = 100001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int C = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[] costs = new int[N];
        int[] cnts = new int[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            costs[i] = Integer.parseInt(st.nextToken()); // 비용
            cnts[i] = Integer.parseInt(st.nextToken()); // 고객의 수
        }

        int[] dp = new int[2001];
        Arrays.fill(dp, INF);
        dp[0] = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 1; j <= 2000; j++) {
                if (j >= cnts[i]) {
                    dp[j] = Math.min(dp[j], dp[j - cnts[i]] + costs[i]);
                }
            }
        }

        int result = INF;

        for (int i = C; i <= 2000; i++) {
            result = Math.min(result, dp[i]);
        }

        System.out.println(result);
    }
}