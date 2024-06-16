import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[][] board = new int[N][N];
        long[][] count = new long[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        count[0][0] = 1;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int len = board[i][j];
                if (len == 0) continue;

                if (j + len < N) { // 오른쪽 점프
                    count[i][j + len] += count[i][j];
                }

                if (i + len < N) { // 아래 점프
                    count[i + len][j] += count[i][j];
                }
            }
        }

        System.out.println(count[N - 1][N - 1]);
    }
}
