import java.io.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            int N = Integer.parseInt(br.readLine()); // 일수
            if (N == 0) break; // 입력 종료

            int[] incomes = new int[N]; // 수익
            int[] dp = new int[N]; // 누적 수익
            int max; // 누적 수익 최댓값

            for (int i = 0; i < N; i++) {
                int income = Integer.parseInt(br.readLine());
                incomes[i] = income;
            }

            dp[0] = max = incomes[0];

            for (int i = 1; i < N; i++) {
                dp[i] = Math.max(dp[i - 1] + incomes[i], incomes[i]);
                max = Math.max(max, dp[i]);
            }

            sb.append(max).append("\n");
        }

        System.out.println(sb);
    }
}