import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine());

            int[][] scores = new int[2][n]; // 스티커 점수 배열
            int[][] dp = new int[2][n]; // 구간별 점수 누적합 배열

            for (int i = 0; i < 2; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    scores[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            dp[0][0] = scores[0][0]; // 윗줄 첫 스티커 점수 담기
            dp[1][0] = scores[1][0]; // 아랫줄 첫 스티커 점수 담기

            for (int i = 1; i < n; i++) {
                // 구간별 최대 점수 구하기
                dp[0][i] = Math.max(dp[1][i - 1] + scores[0][i], dp[0][i - 1] - scores[0][i - 1] + scores[0][i]);
                dp[1][i] = Math.max(dp[0][i - 1] + scores[1][i], dp[1][i - 1] - scores[1][i - 1] + scores[1][i]);
            }

            sb.append(Math.max(dp[0][n - 1], dp[1][n - 1])).append("\n");
        }

        System.out.println(sb);
    }
}