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
        Pos (int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
    static Queue<Pos> queue; // 위치를 담는 큐
    static LinkedList<Integer[]>[][] button; // 불을 켤 수 있는 방 위치
    static boolean[][] visited; // 방문 체크
    static boolean[][] light; // 불이 켜진 방 체크
    static int[] dr = { -1, 0, 1, 0 }; // 행 탐색
    static int[] dc = { 0, 1, 0, -1 }; // 열 탐색
    static int N; // 헛간 크기
    static int M;
    static int max; // 불을 켤 수 있는 방 최대 개수
    static void bfs() {
        queue = new LinkedList<>();
        queue.add(new Pos(1, 1)); // 1, 1 시작
        visited[1][1] = light[1][1] = true; // 방문 처리 및 불 켜기
        max = 1;

        while (!queue.isEmpty()) {
            Pos p = queue.poll();

            int r = p.r; // 현재 행
            int c = p.c; // 현재 열
//            System.out.println("r : " + r + " c : " + c);

            // 현재 방과 인접한 방들 중 불이 켜져있지만 아직 방문하지 않은 곳 방문
            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                if (nr < 1 || nr > N || nc < 1 || nc > N) continue;
                if (light[nr][nc] && !visited[nr][nc]) {
                    visited[nr][nc] = true; // 방문 처리
                    queue.add(new Pos(nr, nc));
                }
            }

            for (int i = 0; i < button[r][c].size(); i++) {
                // 현재 방에서 불을 켤 수 있는 방의 행, 열
                int tmpR = button[r][c].get(i)[0];
                int tmpC = button[r][c].get(i)[1];

                if (light[tmpR][tmpC]) continue; // 이미 불이 켜져 있으면 continue
                light[tmpR][tmpC] = true; // 불 켜기
                max++;

                // 불을 켠 방이 이동할 수 있는 방인지 확인
                for (int d = 0; d < 4; d++) {
                    int nr = tmpR + dr[d]; // 다음 행
                    int nc = tmpC + dc[d]; // 다음 열
                    // 범위를 벗어나거나 불을 켠 방으로 갈 수 없으면 continue
                    if (nr < 1 || nr > N || nc < 1 || nc > N || !light[nr][nc] || !visited[nr][nc]) continue;

                    visited[tmpR][tmpC] = true; // 방문 처리
                    queue.add(new Pos(tmpR, tmpC)); // 불을 켠 방 위치 담기
                    break;
                }
            }
        }
    }

    static void check() {

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        button = new LinkedList[N + 1][N + 1];
        visited = new boolean[N + 1][N + 1];
        light = new boolean[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                button[i][j] = new LinkedList<>();
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int r1 = Integer.parseInt(st.nextToken());
            int c1 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());
            int c2 = Integer.parseInt(st.nextToken());

            button[r1][c1].add(new Integer[] {r2, c2});
        }

        bfs(); // 너비 우선 탐색

        System.out.println(max);
    }
}