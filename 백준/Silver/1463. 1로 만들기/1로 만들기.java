import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int X = Integer.parseInt(br.readLine());

        int[] dp = new int[X + 1];

        if (X == 1) {
            System.out.println(0);
            return;
        } else if (X <= 3) {
            System.out.println(1);
            return;
        }

        dp[2] = 1;
        dp[3] = 1;

        // 동적계획법
        for (int i = 4; i <= X; i++) {
            int min = Integer.MAX_VALUE;

            if (i % 3 == 0) min = Math.min(min, dp[i / 3]);
            if (i % 2 == 0) min = Math.min(min, dp[i / 2]);
            min = Math.min(min, dp[i - 1]);

            dp[i] = min + 1;
        }

        System.out.println(dp[X]);
    }
}