import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] coins = new int[N][M];

        for (int r = 0; r < N; r++) {
            String str = br.readLine();
            for (int c = 0; c < M; c++) {
                coins[r][c] = str.charAt(c) - '0';
            }
        }

        int cnt = 0; // 동전을 뒤집는 횟수

        while (true) {
            boolean chk = false; // 앞면 여부 확인

            Outer: for (int r = N - 1; r >= 0; r--) {
                for (int c = M - 1; c >= 0; c--) {
                    if (coins[r][c] == 1) {
                        coins[r][c] = 0; // 앞면 뒤집기
                        chk = true;
                        // 나머지 동전 뒤집기
                        for (int i = 0; i <= r; i++) {
                            for (int j = 0; j <= c; j++) {
                                if (i == r && j == c) continue;
                                if (coins[i][j] == 0) coins[i][j] = 1;
                                else coins[i][j] = 0;
                            }
                        }

                        break Outer;
                    }
                }
            }

            if (!chk) break; // 모두 앞면

            cnt++;
        }

        System.out.println(cnt);
    }
}