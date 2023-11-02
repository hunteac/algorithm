import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static class Pos {
        int r;
        int c;
        int dist;

        Pos (int r, int c, int dist) {
            this.r = r;
            this.c = c;
            this.dist = dist;
        }
    }

    static StringBuilder sb = new StringBuilder();
    static Queue<Pos> queue;
    static boolean[][] visited; // 방문 체크
    static int[][] map; // 입력 행렬
    static int[][] tmp; // 임시 행렬
    static int[] dr = { -1, 0, 1, 0 };
    static int[] dc = { 0, 1, 0, -1 };
    static int N; // 행 크기
    static int M; // 열 크기

    static void BFS(int a, int b) {
        queue.add(new Pos(a, b, 0));
        visited[a][b] = true;

        while (!queue.isEmpty()) {
            Pos p = queue.poll();

            int r = p.r; // 현재 행 좌표
            int c = p.c; // 현재 열 좌표
            int dist = p.dist; // 현재 지점까지 거리

            map[r][c] = 0;
            tmp[r][c] = dist;

            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d]; // 다음 행 좌표
                int nc = c + dc[d]; // 다음 열 좌표
                if (nr < 0 || nc < 0 || nr >= N || nc >= M || map[nr][nc] == 0 || visited[nr][nc])
                    continue;

                visited[nr][nc] = true;

                queue.add(new Pos(nr, nc, dist + 1));
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        queue = new LinkedList<>();
        visited = new boolean[N][M];
        map = new int[N][M];
        tmp = new int[N][M];

        int r = 0; // 시작 행 좌표
        int c = 0; // 시작 열 좌표

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) {
                    r = i;
                    c = j;
                }
            }
        }

        BFS(r, c); // 너비 우선 탐색

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 1) sb.append(-1).append(" ");
                else sb.append(tmp[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}