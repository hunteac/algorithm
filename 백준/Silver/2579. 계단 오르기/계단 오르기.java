import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] score = new int[N];
        int[] dp = new int[N];

        for (int i = 0; i < N; i++) {
            score[i] = Integer.parseInt(br.readLine());
        }

        if (N == 1) {
            System.out.println(score[0]);
            return;
        } else if (N == 2) {
            System.out.println(score[0] + score[1]);
            return;
        }

        dp[0] = score[0];
        dp[1] = score[0] + score[1];
        dp[2] = Math.max(dp[0] + score[2], score[1] + score[2]);

        int max = 0;

        for (int i = 3; i < N; i++) {
            max = dp[i - 3] + score[i - 1];
            max = Math.max(max, dp[i - 2]);

            dp[i] = max + score[i];
        }

        System.out.println(dp[N - 1]);
    }
}