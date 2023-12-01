import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static class Pos {
        int l; // 현재 층
        int r; // 현재 행
        int c; // 현재 열
        Pos (int l, int r, int c) {
            this.l = l;
            this.r = r;
            this.c = c;
        }
    }
    static Queue<Pos> queue; // bfs 큐
    static boolean[][][] visited; // 방문체크
    static char[][][] building; // 빌딩
    static int[] dl = { -1, 1, 0, 0, 0, 0 }; // 층 탐색
    static int[] dr = { 0, 0, -1, 0, 1, 0 }; // 행 탐색
    static int[] dc = { 0, 0, 0, 1, 0, -1 }; // 열 탐색
    static int L; // 층
    static int R; // 행
    static int C; // 열
    static int time; // 탈출 시간
    static boolean chk; // 탈출 가능 여부
    // 너비 우선 탐색
    static void bfs(int l, int r, int c) {
        queue.add(new Pos(l, r, c)); // Start 지점
        visited[l][r][c] = true; // 방문 처리

        Outer: while(!queue.isEmpty()) {
            int len = queue.size();

            for (int i = 0; i < len; i++) {
                Pos p = queue.poll();

                l = p.l; // 현재 층
                r = p.r; // 현재 행
                c = p.c; // 현재 열

                if (building[l][r][c] == 'E') { // 탈출지점 도착
                    chk = true; //
                    break Outer;
                }

                for (int d = 0; d < 6; d++) {
                    int nl = l + dl[d]; // 다음 층
                    int nr = r + dr[d]; // 다음 행
                    int nc = c + dc[d]; // 다음 열

                    if (nl < 0 || nr < 0 || nc < 0 || nl >= L || nr >= R || nc >= C || visited[nl][nr][nc] ||
                    building[nl][nr][nc] == '#') continue; // 범위를 벗어나거나 방문했거나 갈 수 없으면 continue

                    visited[nl][nr][nc] = true; // 방문 처리

                    queue.add(new Pos(nl, nr, nc)); // 다음 위치 담기
                }
            }

            time++;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());

            L = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());

            if (L == 0 && R == 0 && C == 0) break;

            queue = new LinkedList<>();
            visited = new boolean[L][R][C];
            building = new char[L][R][C];

            chk = false;
            time = 0;
            int l = 0;
            int r = 0;
            int c = 0;

            for (int i = 0; i < L; i++) {
                for (int j = 0; j < R; j++) {
                    String str = br.readLine();
                    for (int k = 0; k < C; k++) {
                        building[i][j][k] = str.charAt(k);
                        if (building[i][j][k] == 'S') {
                            l = i;
                            r = j;
                            c = k;
                        }
                    }

                }
                String tmp = br.readLine();
            }

            bfs(l, r, c);

            if (chk) sb.append("Escaped in " + time + " minute(s).").append("\n"); // 탈출 가능한 경우
            else sb.append("Trapped!").append("\n"); // 탈출 불가능한 경우
        }

        System.out.println(sb);
    }
}