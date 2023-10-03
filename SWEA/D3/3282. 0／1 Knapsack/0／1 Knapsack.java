import java.util.*;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int tc = 1; tc <= T; tc++) {
            int N = sc.nextInt(); // 물건의 개수
            int W = sc.nextInt(); // 가방의 무게

            int[][] bag = new int[N + 1][2]; // bag[][0] = 무게, bag[][1] = 가격

            for (int i = 1; i < N + 1; i++) {
                for (int j = 0; j < 2; j++) {
                    bag[i][j] = sc.nextInt(); // 값 넣기
                }
            }

            int[][] dp = new int[N + 1][W + 1];

            for (int i = 1; i < N + 1; i++) {
                for (int j = 0; j < W + 1; j++) {
                    if (bag[i][0] <= j) {
                        // 물건을 넣을 수 있다면 해당 물건을 넣지 않은 값과 물건을 넣은 값 중 큰 값 넣기
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - bag[i][0]] + bag[i][1]);
                    } else { // 현재 임시 무게 가방에 물건을 넣을 수 없다면 이전 값 넣기
                        dp[i][j] = dp[i - 1][j];
                    }
                }
            }

            System.out.println("#" + tc + " " + dp[N][W]); // 최종 값 출력
        }
    }
}