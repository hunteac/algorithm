import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static class Pos { // 좌표 클래스
        int r;
        int c;

        Pos (int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static int[][] map; // 격자

    // 직사각형이 이동할 수 있는지 체크
    static boolean check(int d, int r, int c, int rLen, int cLen) {
        boolean chk = true;

        if (d == 0) {
            for (int idx = c; idx < c + cLen; idx++) {
                if (map[r][idx] == 1) {
                    chk = false;
                    break;
                }
            }
        } else if (d == 1) {
            for (int idx = r; idx < r + rLen; idx++) {
                if (map[idx][c + cLen - 1] == 1) {
                    chk = false;
                    break;
                }
            }
        } else if (d == 2) {
            for (int idx = c; idx < c + cLen; idx++) {
                if (map[r + rLen - 1][idx] == 1) {
                    chk = false;
                    break;
                }
            }
        } else {
            for (int idx = r; idx < r + rLen; idx++) {
                if (map[idx][c] == 1) {
                    chk = false;
                    break;
                }
            }
        }

        return chk;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());

        int rLen = Integer.parseInt(st.nextToken()); // 행 길이
        int cLen = Integer.parseInt(st.nextToken()); // 열 길이
        int startR = Integer.parseInt(st.nextToken()) - 1; // 출발 좌표
        int startC = Integer.parseInt(st.nextToken()) - 1;
        int endR = Integer.parseInt(st.nextToken()) - 1; // 도착 좌표
        int endC = Integer.parseInt(st.nextToken()) - 1;

        int[] dr = { -1, 0, 1, 0 };
        int[] dc = { 0, 1, 0, -1 };

        Queue<Pos> queue = new LinkedList<>();
        boolean[][] visited = new boolean[N][M]; // 방문 체크

        queue.add(new Pos(startR, startC));
        visited[startR][startC] = true;

        int min = Integer.MAX_VALUE;
        int cnt = 0;

        while (!queue.isEmpty()) { // 너비 우선 탐색
            int len = queue.size();

            for (int i = 0; i < len; i++) {

                Pos p = queue.poll();

                int r = p.r; // 현재 행
                int c = p.c; // 현재 열

                if (r == endR && c == endC) { // 도착
                    min = cnt; // 최솟값 갱신
                    break;
                }

                for (int d = 0; d < 4; d++) {
                    int nr = r + dr[d]; // 다음 행
                    int nc = c + dc[d]; // 다음 열

                    if (nr < 0 || nr + rLen > N || nc < 0 || nc + cLen > M || visited[nr][nc]) continue;

                    boolean chk = check(d, nr, nc, rLen, cLen);

                    if (!chk) continue;

                    visited[nr][nc] = true; // 방문 처리

                    queue.add(new Pos(nr, nc));
                }
            }

            cnt++;
        }

        if (min != Integer.MAX_VALUE) System.out.println(min);
        else System.out.println(-1);
    }
}