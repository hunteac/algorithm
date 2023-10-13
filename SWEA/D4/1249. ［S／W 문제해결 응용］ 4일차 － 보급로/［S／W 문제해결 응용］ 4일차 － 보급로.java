import java.util.*;

class Solution {
    static class Pos { // 현재 위치
        int r;
        int c;
        int time;

        Pos (int r, int c, int time) {
            this.r = r;
            this.c = c;
            this.time = time;
        }
    }

    static Queue<Pos> queue; // BFS 큐
    static int[][] times; // 구간별 최소 복구 시간
    static int[][] map; // 지도
    static int[] dr = { -1, 0, 1, 0 }; // 상, 우, 하, 좌
    static int[] dc = { 0, 1, 0, -1 };
    static int N; // 크기

    static void BFS() {
        queue.add(new Pos(0, 0, 0));
        times[0][0] = 0;

        while(!queue.isEmpty()) {
            Pos p = queue.poll();

            int r = p.r; // 현재 행
            int c = p.c; // 현재 열
            int time = p.time; // 현재 복구 시간

            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];
                if (nr < 0 || nc < 0 || nr >= N || nc >= N) continue;

                int next = time + map[nr][nc]; // 다음 칸의 복구 시간

                if (times[nr][nc] > next) { // 현재 가지고 있는 다음 칸 복구 시간 보다 작으면
                    times[nr][nc] = next; // 값 갱신
                    queue.add(new Pos(nr, nc, next)); // 이동
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int tc = 1; tc <= T; tc++) {
            N = sc.nextInt();

            queue = new LinkedList<>();
            times = new int[N][N];
            map = new int[N][N];

            for (int i = 0; i < N; i++) {
                String s = sc.next();
                for (int j = 0; j < N; j++) {
                    map[i][j] = s.charAt(j) - '0';
                    times[i][j] = Integer.MAX_VALUE;
                }
            }

            BFS();

            System.out.println("#" + tc + " " + times[N - 1][N - 1]);
        }
    }
}