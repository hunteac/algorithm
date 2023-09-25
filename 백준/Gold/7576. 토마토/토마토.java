import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static class Tomato { // 토마토 생성 객체
        int r;
        int c;
        Tomato(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static Queue<Tomato> queue; // BFS 큐
    static boolean[][] visited; // 방문 체크
    static int[][] box; // 토마토 상자
    static int[] dr = { -1, 0, 1, 0 };
    static int[] dc = { 0, 1, 0, -1 };
    static int N; // 상자 세로
    static int M; // 상자 가로
    static int min; // 최소 날짜

    // 깊이 우선 탐색 메소드
    static void BFS() {
        while (!queue.isEmpty()) {
            int size = queue.size();
            min++;
            for (int i = 0; i < size; i++) {
                Tomato t = queue.poll();
                int cr = t.r; // 현재 행 좌표
                int cc = t.c; // 현재 열 좌표

                for (int d = 0; d < 4; d++) {
                    int nr = cr + dr[d]; // 다음 행 좌표
                    int nc = cc + dc[d]; // 다음 열 좌표
                    if (nr < 0 || nc < 0 || nr >= N || nc >= M || visited[nr][nc] || box[nr][nc] == -1)
                        continue;
                    visited[nr][nc] = true; // 방문 처리
                    if (box[nr][nc] == 1) continue; // 이미 익은 토마토는 continue
                    else box[nr][nc] = 1; // 토마토 익히기
                    queue.add(new Tomato(nr, nc)); // 익힌 토마토 큐에 넣기
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        queue = new LinkedList<>();

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        min = -1;

        visited = new boolean[N][M];
        box = new int[N][M];

        int nripen = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                box[i][j] = Integer.parseInt(st.nextToken());
                if (box[i][j] == 0) nripen++;
            }
        }

        if (nripen == 0) { // 처음부터 모든 토마토가 익어있는 상태
            System.out.println(0); // 0 출력
            return;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (box[i][j] == 1) queue.add(new Tomato(i, j)); // 0일차에 익은 토마토들 큐에 넣기
            }
        }

        BFS();

        boolean chk = true; // 모든 토마토가 익었는지 확인

        Outer: for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (box[i][j] == 0) { // 안익은 토마토가 있다면 false
                    chk = false;
                    break Outer;
                }
            }
        }

        if (chk) System.out.println(min); // 다 익었다면 최소 날짜 출력
        else System.out.println(-1); // 익지 않았다면 -1 출력
    }
}