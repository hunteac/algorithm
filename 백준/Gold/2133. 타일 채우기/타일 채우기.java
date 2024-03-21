import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        if (N % 2 == 1) { // 홀수는 불가능
            System.out.println(0);
            return;
        }

        int[] dp = new int[31];

        dp[0] = 1;
        dp[2] = 3;

        for (int i = 4; i <= N; i++) {
            dp[i] = dp[i - 2] * 4 - dp[i - 4]; // 점화식
        }

        System.out.println(dp[N]);
    }
}
