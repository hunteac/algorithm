import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 계단 개수

        int[] stair = new int[N];
        int[] dp = new int[N];

        for (int i = 0; i < N; i++) stair[i] = Integer.parseInt(br.readLine());

        dp[0] = stair[0];

        for (int i = 1; i < N; i++) {
            if (i == 1) {
                dp[i] = dp[i - 1] + stair[i];
            } else {
                if (i > 2) dp[i] = Math.max(stair[i] + stair[i - 1] + dp[i - 3], stair[i] + dp[i - 2]);
                else dp[i] = Math.max(stair[i] + stair[i - 1], stair[i] + stair[i - 2]);
            }

//            System.out.println("i : " + i + " dp : " + dp[i]);
        }

        System.out.println(dp[N - 1]);
    }
}