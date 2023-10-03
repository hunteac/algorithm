import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // 거스름돈

        int[] dp = new int[n + 1]; // 각 원의 거스름돈 최소 개수

        for (int i = 2; i <= n; i++) {
            int min = Integer.MAX_VALUE; // 최솟값

            if (i >= 2 && (i % 2 == 0 || (i - 2) % 5 == 0)) min = Math.min(min, dp[i - 2] + 1);
            if (i >= 5 && (i % 5 == 0 ||(i - 5) % 2 == 0)) min = Math.min(min, dp[i - 5] + 1);

            if (min != Integer.MAX_VALUE) dp[i] = min;
        }

        if (dp[n] != 0) System.out.println(dp[n]);
        else System.out.println(-1); // 거슬러 줄 수 없으면 -1 출력
    }
}