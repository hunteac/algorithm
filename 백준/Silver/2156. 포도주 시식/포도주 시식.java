import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] dp = new int[N][2];
        int[] nums = new int[N];

        for (int i = 0; i < N; i++) nums[i] = Integer.parseInt(br.readLine());

        // 0 == 해당 인덱스 선택, 1 == 해당 인덱스 선택 X
        dp[0][0] = nums[0];

        if (N > 1) {
            dp[1][0] = dp[0][0] + nums[1];
            dp[1][1] = dp[0][0];
        }

        for (int i = 2; i < N; i++) {
            dp[i][0] = Math.max(dp[i - 2][0] + nums[i], dp[i - 2][1] + nums[i - 1] + nums[i]); // 선택
            dp[i][1] = Math.max(dp[i - 1][0], dp[i - 1][1]); // 선택 X
        }

        System.out.println(Math.max(dp[N - 1][0], dp[N - 1][1]));
    }
}