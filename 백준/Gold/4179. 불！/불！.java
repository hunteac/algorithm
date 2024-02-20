import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Pos {
        int r;
        int c;
        int time;
        Pos (int r, int c, int time) {
            this.r = r;
            this.c = c;
            this.time = time;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int R = Integer.parseInt(st.nextToken()); // 행
        int C = Integer.parseInt(st.nextToken()); // 열
        int min = Integer.MAX_VALUE; // 탈출 가능 최소 시간

        boolean[][] visited = new boolean[R][C]; // 방문 체크
        char[][] maze = new char[R][C]; // 미로
        int[][] fired = new int[R][C]; // 불이 번진 날짜
        int[] dr = { -1, 0, 1, 0 }; // 행 탐색
        int[] dc = { 0, 1, 0, -1 }; // 열 탐색

        Queue<Pos> pos = new LinkedList<>(); // 지훈 위치
        Queue<Pos> fire = new LinkedList<>(); // 불 위치

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                fired[i][j] = Integer.MAX_VALUE;
            }
        }

        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int j = 0; j < C; j++) {
                maze[i][j] = str.charAt(j);
                if (maze[i][j] == 'J') {
                    pos.add(new Pos(i, j, 0)); // 지훈 출발 위치
                    visited[i][j] = true;
                } else if (maze[i][j] == 'F') {
                    fire.add(new Pos(i, j, 0));
                    fired[i][j] = 0;
                }
            }
        }

        int day = 1;

        // 불 붙이기
        while (!fire.isEmpty()) {
            int len = fire.size();

            for (int idx = 0; idx < len; idx++) {
                Pos f = fire.poll();

                for (int d = 0; d < 4; d++) {
                    int nr = f.r + dr[d];
                    int nc = f.c + dc[d];
                    if (nr < 0 || nc < 0 || nr >= R || nc >= C || maze[nr][nc] == '#' || fired[nr][nc] != Integer.MAX_VALUE) continue;

                    fired[nr][nc] = day;
                    fire.add(new Pos(nr, nc, 0));
                }
            }

            day++;
        }

        day = 1;

        while (!pos.isEmpty()) {
            // 지훈 이동
            int len = pos.size();
            for (int l = 0; l < len; l++) {
                Pos p = pos.poll(); // 현재 위치
                int r = p.r; // 현재 행
                int c = p.c; // 현재 열
                int time = p.time; // 현재 시간

                for (int d = 0; d < 4; d++) {
                    int nr = r + dr[d]; // 다음 행
                    int nc = c + dc[d]; // 다음 열
                    if (nr < 0 || nc < 0 || nr >= R || nc >= C) { // 탈출
                        min = Math.min(min, time + 1); // 최소 시간 갱신
                        continue;
                    }
                    // 벽이거나 이미 불이 붙은 곳은 continue
                    if (maze[nr][nc] == '#' || visited[nr][nc] || fired[nr][nc] <= day) continue;
                    visited[nr][nc] = true;

                    pos.add(new Pos(nr, nc, time + 1));
                }
            }

            day++;
        }

        if (min == Integer.MAX_VALUE) System.out.println("IMPOSSIBLE"); // 탈출 불가능
        else System.out.println(min); // 탈출 가능
    }
}