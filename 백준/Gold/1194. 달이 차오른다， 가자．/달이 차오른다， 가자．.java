import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Pos {
        int r;
        int c;
        int key;

        Pos (int r, int c, int key) {
            this.r = r;
            this.c = c;
            this.key = key;
        }
    }

    static Queue<Pos> queue;
    static boolean[][][] visited;
    static char[][] maze;
    static int[] dr = { -1, 0, 1, 0 };
    static int[] dc = { 0, 1, 0, -1 };
    static int N;
    static int M;
    static int min; // 최소 이동 횟수
    static boolean chk;

    static void bfs() {
        int cnt = 0; // 이동 횟수

        Outer: while (!queue.isEmpty()) {
            int len = queue.size();

            for (int i = 0; i < len; i++) {
                Pos p = queue.poll();

                int r = p.r;
                int c = p.c;
                int key = p.key;

                if (maze[r][c] == '1') {
                    chk = true;
                    min = cnt;
                    break Outer;
                }

                if (maze[r][c] >= 'a' && maze[r][c] <= 'f') {
                    key |= (1 << (maze[r][c] - 'a'));
                }

                for (int d = 0; d < 4; d++) {
                    int nr = r + dr[d];
                    int nc = c + dc[d];
                    if (nr < 0 || nr >= N || nc < 0 || nc >= M || visited[key][nr][nc] || maze[nr][nc] == '#') continue;

                    if (maze[nr][nc] >= 'A' && maze[nr][nc] <= 'F') {
                        if ((key & (1 << (maze[nr][nc] - 'A'))) != (1 << (maze[nr][nc] - 'A'))) continue;
                    }

                    visited[key][nr][nc] = true;

                    queue.add(new Pos(nr, nc, key));
                }
            }

            cnt++;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        queue = new LinkedList<>();
        visited = new boolean[64][N][M];
        maze = new char[N][M];
        min = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                maze[i][j] = str.charAt(j);
                if (maze[i][j] == '0') {
                    queue.add(new Pos(i, j, 0));
                    visited[0][i][j] = true;
                }
            }
        }

        bfs();

        if (chk) System.out.println(min);
        else System.out.println(-1);
    }
}