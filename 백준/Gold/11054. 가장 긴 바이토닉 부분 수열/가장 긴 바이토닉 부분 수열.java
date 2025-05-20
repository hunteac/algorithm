import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] dp = new int[N][2];
        int[] nums = new int[N];
        int[] maxArr = new int[N];
        int max = 1;

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) nums[i] = Integer.parseInt(st.nextToken());

        // 0: 증가, 1: 감소
        dp[0][0] = dp[0][1] = maxArr[0] = 1;

        for (int i = 1; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) { // 증가
                    dp[i][0] = Math.max(dp[i][0], dp[j][0] + 1);
                    maxArr[i] = Math.max(dp[i][0], maxArr[i]);
                } else if (nums[i] < nums[j]) { // 감소
                    dp[i][1] = Math.max(dp[i][1], dp[j][1] + 1);
                    maxArr[i] = Math.max(dp[i][1], maxArr[i]);
                    maxArr[i] = Math.max(maxArr[j] + 1, maxArr[i]);
                }
            }

            dp[i][0] = dp[i][0] == 0 ? 1 : dp[i][0];
            dp[i][1] = dp[i][1] == 0 ? 1 : dp[i][1];

            max = Math.max(maxArr[i], max);
        }

        System.out.println(max);
    }
}