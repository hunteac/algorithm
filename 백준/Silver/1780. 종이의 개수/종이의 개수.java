import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int minus = 0, zero = 0, plus = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[][] paper = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        getPaper(paper, N, 0, 0);

        sb.append(minus).append("\n").append(zero).append("\n").append(plus).append("\n");

        System.out.println(sb);
    }

    public static void getPaper(int[][] paper, int N, int r, int c) {
        boolean chk = true;

        int start = paper[r][c];

        for (int i = r; i < r + N; i++) {
            for (int j = c; j < c + N; j++) {
                if (paper[i][j] != start) {
                    chk = false;
                    break;
                }
            }
        }

        if (chk) {
            if (start == -1) minus++;
            if (start == 0) zero++;
            if (start == 1) plus++;
        } else {
            int next = N / 3;

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    getPaper(paper, next, r + next * i, c + next * j);
                }
            }
        }
    }
}