import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static boolean[][] visited; // 방문 체크
    static int[][] farm; // 농장
    static int[] dr = { -1, -1, -1, 0, 1, 1, 1, 0 }; // 행 탐색
    static int[] dc = { -1, 0, 1, 1, 1, 0, -1, -1 }; // 열 탐색
    static int N, M, cnt;
    static boolean chk;

    // 산봉우리 체크
    static void checkPeak(int r, int c, int num) {
        visited[r][c] = true; // 방문 처리

        for (int d = 0; d < 8; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];
            if (nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
            if (farm[nr][nc] <= num && visited[nr][nc]) continue;

            if (farm[nr][nc] == num) checkPeak(nr, nc, num);
            else if (farm[nr][nc] > num) chk = false; // 산봉우리 조건 미충족
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        farm = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                farm[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        cnt = 0;

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                if (visited[r][c]) continue;

                chk = true;
                checkPeak(r, c, farm[r][c]); // 산봉우리 체크

                if (farm[r][c] > 0 && chk) cnt++; // 산봉우리 수 +1
            }
        }

        System.out.println(cnt);
    }
}
