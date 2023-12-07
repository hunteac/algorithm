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
        int time;
        boolean chk;
        Pos (int r, int c, int time, boolean chk) {
            this.r = r;
            this.c = c;
            this.time = time;
            this.chk = chk;
        }
    }

    static int N, M, T;
    static boolean[][][] visited; // 방문 체크
    static int[][] map; // 맵
    static int[] dr = { -1, 0, 1, 0 }; // 행 탐색
    static int[] dc = { 0, 1, 0, -1 }; // 열 탐색
    // 너비 우선 탐색
    static int bfs() {
        Queue<Pos> queue = new LinkedList<>();
        queue.add(new Pos(0, 0, 0, false));
        visited[0][0][0] = true;

        while (!queue.isEmpty()) {
            Pos p = queue.poll(); // 현재 위치
            int r = p.r; // 현재 행
            int c = p.c; // 현재 열
            int time = p.time; // 현재 시간
            boolean chk = p.chk; // 그람 획득 여부

            if (time > T) break; // 제한 시간 초과
            if (r == N - 1 && c == M - 1) return time; // 공주 탈출

            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d]; // 다음 행
                int nc = c + dc[d]; // 다음 열

                if (nr < 0 || nr >= N || nc < 0 || nc >= M) continue; // 범위를 벗어나면 continue

                if (!chk) { // 그람 X
                    if (!visited[nr][nc][0] && map[nr][nc] == 0) {
                        visited[nr][nc][0] = true;
                        queue.add(new Pos(nr, nc, time + 1, false));
                    } else if (!visited[nr][nc][0] && map[nr][nc] == 2) {
                        visited[nr][nc][0] = true;
                        queue.add(new Pos(nr, nc, time + 1, true));
                    }
                } else { // 그람 O
                    if (visited[nr][nc][1]) continue;
                    visited[nr][nc][1] = true;
                    queue.add(new Pos(nr, nc, time + 1, true));
                }
            }
        }
        return -1; // 시간 안에 탈출 불가능
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 행 크기
        M = Integer.parseInt(st.nextToken()); // 열 크기
        T = Integer.parseInt(st.nextToken()); // 제한 시간

        visited = new boolean[N][M][2];
        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int time = bfs();

        if (time == -1) System.out.println("Fail"); // 제한 시간 안에 구출 불가
        else System.out.println(time); // 제한 시간 안에 구출 가능
    }
}