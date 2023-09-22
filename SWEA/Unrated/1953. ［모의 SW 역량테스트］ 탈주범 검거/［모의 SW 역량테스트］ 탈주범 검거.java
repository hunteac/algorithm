import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Solution {
    static class Escape { // 탈출범 위치 객체 생성 클래스
        int r;
        int c;
        Escape(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static Queue<Escape> queue;
    static boolean[][] visited; // 방문 체크
    static int[][] map; // 지하 터널
    static int[] dr = { -1, 0, 1, 0 };
    static int[] dc = { 0, 1, 0, -1 };
    static int L; // 탈출 후 소요된 시간
    static int cnt; // 위치할 수 있는 장소 수

    static void BFS(int r, int c) {
        visited[r][c] = true;
        queue.add(new Escape(r, c));

        while (!queue.isEmpty()) {
            if (--L == 0) return; // 소요 시간 끝
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Escape e = queue.poll();
                int cr = e.r; // 현재 세로 위치
                int cc = e.c; // 현재 가로 위치

                for (int d = 0; d < 4; d++) {
                    int rr = cr + dr[d];
                    int rc = cc + dc[d];
                    if (rr < 0 || rc < 0 || rr >= map.length || rc >= map[0].length || visited[rr][rc] || map[rr][rc] == 0) continue;

                    if (d == 0) { // 상
                        if (map[rr][rc] == 3 || map[rr][rc] == 4 || map[rr][rc] == 7) continue;
                        if (map[cr][cc] == 1 || map[cr][cc] == 2 || map[cr][cc] == 4 || map[cr][cc] == 7) {
                            queue.add(new Escape(rr, rc));
                            visited[rr][rc] = true;
                            cnt++;
                        }
                    } else if (d == 1) { // 우
                        if (map[rr][rc] == 2 || map[rr][rc] == 4 || map[rr][rc] == 5) continue;
                        if (map[cr][cc] == 1 || map[cr][cc] == 3 || map[cr][cc] == 4 || map[cr][cc] == 5) {
                            queue.add(new Escape(rr, rc));
                            visited[rr][rc] = true;
                            cnt++;
                        }
                    } else if (d == 2) { // 하
                        if (map[rr][rc] == 3 || map[rr][rc] == 5 || map[rr][rc] == 6) continue;
                        if (map[cr][cc] == 1 || map[cr][cc] == 2 || map[cr][cc] == 5 || map[cr][cc] == 6) {
                            queue.add(new Escape(rr, rc));
                            visited[rr][rc] = true;
                            cnt++;
                        }
                    } else { // 좌
                        if (map[rr][rc] == 2 || map[rr][rc] == 6 || map[rr][rc] == 7) continue;
                        if (map[cr][cc] == 1 || map[cr][cc] == 3 || map[cr][cc] == 6 || map[cr][cc] == 7) {
                            queue.add(new Escape(rr, rc));
                            visited[rr][rc] = true;
                            cnt++;
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            queue = new LinkedList<>();

            int N = Integer.parseInt(st.nextToken()); // 지도 세로
            int M = Integer.parseInt(st.nextToken()); // 지도 가로
            int R = Integer.parseInt(st.nextToken()); // 맨홀 세로
            int C = Integer.parseInt(st.nextToken()); // 맨홀 가로
            L = Integer.parseInt(st.nextToken());
            cnt = 1; // 첫 위치 = 맨홀

            visited = new boolean[N][M];
            map = new int[N][M];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < M; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            BFS(R, C);

            System.out.println("#" + tc + " " + cnt);
        }
    }
}