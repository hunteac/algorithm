import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static boolean[][] visited; // 방문 체크
    static char[][] board; // 게임판
    static int[] dr = { -1, 0, 1, 0 }; // 행 탐색
    static int[] dc = { 0, 1, 0, -1 }; // 열 탐색
    static int N; // 행 크기
    static int M; // 열 크기
    static boolean chk;

    static void dfs(int startR, int startC, int r, int c, int cnt, char color) {
        visited[r][c] = true; // 방문 처리

        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];
            if (cnt > 2 && nr == startR && nc == startC && board[nr][nc] == color) { // 사이클 완성
                chk = true;
                return;
            }
            if (nr < 0 || nr >= N || nc < 0 || nc >= M || visited[nr][nc] || board[nr][nc] != color) continue;

            dfs(startR, startC, nr, nc, cnt + 1, color);
        }

        visited[r][c] = false; // 백트래킹
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new boolean[N][M];
        board = new char[N][M];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = str.charAt(j);
            }
        }

        chk = false;

        Outer: for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                dfs(i, j, i, j, 1, board[i][j]);
                if (chk) break Outer;
            }
        }

        if (chk) System.out.println("Yes");
        else System.out.println("No");
    }
}