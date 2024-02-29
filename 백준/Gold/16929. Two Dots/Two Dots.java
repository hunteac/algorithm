import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static boolean[][] visited; // 방문 체크
    static char[][] board; // 게임판
    static int[][] boardCnt; // 사이클 순서
    static int[] dr = { -1, 0, 1, 0 }; // 행 탐색
    static int[] dc = { 0, 1, 0, -1 }; // 열 탐색
    static int N; // 행 크기
    static int M; // 열 크기
    static boolean chk;

    static void dfs(int r, int c, int cnt, char color) {
        visited[r][c] = true; // 방문 처리
        boardCnt[r][c] = cnt; // 순서 저장

        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];
            if (nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
            if (boardCnt[nr][nc] != 0 && cnt - boardCnt[nr][nc] > 2 && board[nr][nc] == color) { // 사이클 완성
                chk = true;
                return;
            }
            if (visited[nr][nc] || board[nr][nc] != color) continue;

            dfs(nr, nc, cnt + 1, color);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new boolean[N][M];
        board = new char[N][M];
        boardCnt = new int[N][M];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = str.charAt(j);
            }
        }

        chk = false;

        Outer: for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (visited[i][j]) continue;
                dfs(i, j, 1, board[i][j]);
                if (chk) break Outer;
            }
        }

        if (chk) System.out.println("Yes");
        else System.out.println("No");
    }
}