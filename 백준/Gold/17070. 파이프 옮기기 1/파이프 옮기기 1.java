import java.io.*;
import java.util.*;

public class Main {
    static class Pipe { // 파이프 객체 생성 클래스
        int lr; // 왼쪽 행
        int lc; // 왼쪽 열
        int rr; // 오른쪽 행
        int rc; // 오른쪽 열

        Pipe(int lr, int lc, int rr, int rc) {
            this.lr = lr;
            this.lc = lc;
            this.rr = rr;
            this.rc = rc;
        }
    }

    static int[][] house; // 집
    static int[] dr = { 0, 1, 1 }; // 우, 하, 대각선 탐색
    static int[] dc = { 1, 0, 1 };
    static int N; // 집 크기
    static int cnt; // 이동 방법 수

    // 깊이 우선 메소드
    static void DFS (int lr, int lc, int rr, int rc) {
        if (rr == N - 1 && rc == N - 1) {
            cnt++;
            return;
        }

        for (int d = 0; d < 3; d++) {
            int nr = rr + dr[d];
            int nc = rc + dc[d];
            if (nr >= N || nc >= N || house[nr][nc] == 1) continue;

            // 빈칸이어야 하는 곳에 벽이 있으면 이동 불가
            if (d == 2 && (house[nr][nc - 1] == 1 || house[nr - 1][nc] == 1)) continue;

            if (rr - lr == 0) { // 가로
                if (d == 1) continue; // 가로 -> 세로 이동 불가능
                DFS(rr, rc, nr, nc);
            } else if (rc - lc == 0) { // 세로
                if (d == 0) continue; // 세로 -> 가로 이동 불가능
                DFS(rr, rc, nr, nc); // 세로, 대각선 방향 이동
            } else { // 대각선
                DFS(rr, rc, nr, nc); // 가로, 세로, 대각선 방향 이동
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        house = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                house[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        DFS(0, 0, 0, 1); // 시작 좌표 ((0, 0), (0, 1))

        System.out.println(cnt);
    }
}