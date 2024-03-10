import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Pos {
        int r; // 현재 행
        int c; // 현재 열
        int cnt; // 부순 벽 개수
        boolean chk; // 벽을 부쉈는지 체크

        Pos (int r, int c, int cnt, boolean chk) {
            this.r = r;
            this.c = c;
            this.cnt = cnt;
            this.chk = chk;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        boolean[][][] visited = new boolean[2][N][M];
        int[][] map = new int[N][M];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }

        Queue<Pos> queue = new LinkedList<>();
        int[] dr = { -1, 0, 1, 0 };
        int[] dc = { 0, 1, 0, -1 };

        queue.add(new Pos(0, 0, 1, false));
        visited[0][0][0] = true;

        int min = Integer.MAX_VALUE;

        while (!queue.isEmpty()) {
            Pos p = queue.poll();

            int r = p.r;
            int c = p.c;
            int cnt = p.cnt;
            boolean chk = p.chk;

//            System.out.println(r + " " + c);

            if (r == N - 1 && c == M - 1) { // 도착
                min = Math.min(min, cnt); // 최솟값 갱신
            }

            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];
                if (nr < 0 || nr >= N || nc < 0 || nc >= M || (chk && map[nr][nc] == 1)) continue;

                // 0 == 벽을 부수기 전 방문 처리, 1 == 벽을 부순 후 방문 처리
                if ((chk && (visited[0][nr][nc] || visited[1][nr][nc])) || (!chk && visited[0][nr][nc])) continue;

                if (chk) {
                    visited[1][nr][nc] = true;
                    queue.add(new Pos(nr, nc, cnt + 1, true));
                } else {
                    if (map[nr][nc] == 1) { // 벽 부수기
                        visited[1][nr][nc] = true; // 방문 처리
                        queue.add(new Pos(nr, nc, cnt + 1, true));
                    } else {
                        visited[0][nr][nc] = true; // 방문 처리
                        queue.add(new Pos(nr, nc, cnt + 1, false));
                    }
                }

            }
        }

        if (min != Integer.MAX_VALUE) System.out.println(min);
        else System.out.println(-1);
    }
}