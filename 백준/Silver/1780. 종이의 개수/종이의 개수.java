import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int[][] paper;
    public static int[] cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        paper = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        cnt = new int[3];
        getPaper(N, 0, 0);

        for (int i = 0; i < 3; i++) {
            System.out.println(cnt[i]);
        }
    }

    public static void getPaper(int N, int r, int c) {
        int color = paper[r][c];
        int next = N / 3;

        for (int i = r; i < r + N; i++) {
            for (int j = c; j < c + N; j++) {
                if (paper[i][j] != color) {

                    for (int k = 0; k < 3; k++) {
                        for (int l = 0; l < 3; l++) {
                            getPaper(next, r + next * k, c + next * l);
                        }
                    }

                    return;
                }
            }
        }

        cnt[color + 1]++;
    }
}