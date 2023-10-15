import java.io.*;
import java.util.*;

public class Main {
    // 동적계획법의 핵심은 메모이제이션(부분 문제 결과 저장)
    static int[][][] dp = new int[21][21][21];

    static int w(int a, int b, int c) {

        if (isRange(a, b, c) && dp[a][b][c] != 0) return dp[a][b][c];

        if (a <= 0 || b <= 0 || c <= 0) return 1;

        if (a > 20 || b > 20 || c > 20) return dp[20][20][20] = w(20, 20, 20);

        if (a < b && b < c) return dp[a][b][c] = w(a, b, c - 1) + w(a, b - 1, c - 1) - w(a, b - 1, c);

        return dp[a][b][c] = w(a - 1, b, c) + w(a - 1, b - 1, c) + w(a - 1, b, c - 1) - w(a - 1, b - 1, c - 1);
    }
    // 범위 체크
    static boolean isRange(int a, int b, int c) {

        return a >= 0 && a <= 20 && b >=0 && b <= 20 && c >= 0 && c <= 20;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (a == -1 && b == -1 && c == -1) break;

            System.out.printf("w(%d, %d, %d) = %d\n", a, b, c, w(a, b, c));
        }
    }
}