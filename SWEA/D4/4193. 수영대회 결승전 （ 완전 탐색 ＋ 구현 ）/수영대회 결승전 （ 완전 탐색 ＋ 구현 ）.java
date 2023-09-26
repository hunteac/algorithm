import java.io.*;
import java.util.*;

public class Solution {
    static class Pos { // 현재 위치 생성 클래스
        int r; // 행 위치
        int c; // 열 위치
        int t; // 시간
        Pos(int r, int c, int t) {
            this.r = r;
            this.c = c;
            this.t = t;
        }
    }

    static Queue<Pos> queue; // BFS 큐
    static boolean[][] visited; // 방문 체크
    static int[][] pool; // 수영장
    static int[] dr = { -1, 0, 1, 0 }; // 행 탐색
    static int[] dc = { 0, 1, 0, -1 }; // 열 탐색
    static int N; // 수영장 크기
    static int gr; // 목표 지점 행
    static int gc; // 목표 지점 열
    static int min; // 최소 시간
    static boolean chk; // 도달 가능 여부

    // 깊이 우선 탐색 메소드
    static void BFS(int r, int c) {
        visited[r][c] = true;
        queue.add(new Pos(r, c, 0));

        while (!queue.isEmpty()) {
            Pos p = queue.poll();
            int cr = p.r; // 현재 행 좌표
            int cc = p.c; // 현재 열 좌표
            int t = p.t; // 현재 시간

            if (cr == gr && cc == gc) { // 목표 지점 도달
                min = t;
                chk = true;
                return;
            }

            for (int d = 0; d < 4; d++) {
                int rr = cr + dr[d]; // 다음 행 좌표
                int rc = cc + dc[d]; // 다음 열 좌표
                if (rr < 0 || rc < 0 || rr >= N || rc >= N || visited[rr][rc] || pool[rr][rc] == 1)
                    continue;

                if (pool[rr][rc] == 2) { // 다음으로 갈 장소가 소용돌이일 때
                    if ((t + 1) % 3 != 0) { // 사라지지 않았다면 동일 위치를 시간만 증가시키고 큐에 다시 넣기
                        queue.add(new Pos(cr, cc, t + 1));
                        continue;
                    }
                }

                visited[rr][rc] = true; // 방문 처리

                queue.add(new Pos(rr, rc, t + 1));
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());

            queue = new LinkedList<>();
            visited = new boolean[N][N];
            pool = new int[N][N];
            chk = false;
            min = 0;

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    pool[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()); // 시작 행 좌표
            int c = Integer.parseInt(st.nextToken()); // 시작 열 좌표

            st = new StringTokenizer(br.readLine());
            gr = Integer.parseInt(st.nextToken());
            gc = Integer.parseInt(st.nextToken());

            BFS(r, c);

            if (chk) System.out.println("#" + tc + " " + min); // 목표 지점까지 도달할 수 있다면 최소 시간 출력
            else System.out.println("#" + tc + " " + -1); // 없다면 -1 출력
        }
    }
}