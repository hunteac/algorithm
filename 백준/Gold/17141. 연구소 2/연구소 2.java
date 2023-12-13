import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static class Virus {
        int r;
        int c;
        Virus (int r, int c) {
            this.r = r;
            this.c = c;
        }

    }
    static Queue<Virus> queue;
    static LinkedList<Integer[]> pos; // 바이러스 활성화 가능 위치
    static boolean[][] visited; // 방문 체크
    static int[][] tmpPos; // 바이러스 활성화 위치
    static int[][] lab; // 연구실
    static int[][] tmp; // 임시 연구실
    static int[] dr = { -1, 0, 1, 0 };
    static int[] dc = { 0, 1, 0, -1 };
    static int N; // 연구실 크기
    static int M; // 바이러스 활성화 가능 개수
    static int min; // 최소시간
    static int time; // 활성화 시간
    // 조합 알고리즘
    static void comb(int idx1, int idx2) {
        if (idx1 == M) {
            queue = new LinkedList<>();
            tmp = new int[N][N];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (lab[i][j] == 1) tmp[i][j] = 1;
                }
            }

            for (int i = 0; i < M; i++) {
                queue.add(new Virus(tmpPos[i][0], tmpPos[i][1]));
                tmp[tmpPos[i][0]][tmpPos[i][1]] = 2;
            }

            bfs();

            boolean chk = true;

            Outer: for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (tmp[i][j] == 0) {
                        chk = false;
                        break Outer;
                    }
                }
            }

            if (chk) min = Math.min(min, time); // 최소시간 갱신
            return; // 종료
        }

        if (idx2 == pos.size()) return;

        tmpPos[idx1][0] = pos.get(idx2)[0];
        tmpPos[idx1][1] = pos.get(idx2)[1];
        comb(idx1 + 1, idx2 + 1);
        comb(idx1, idx2 + 1);
    }

    static void bfs() {
        visited = new boolean[N][N];
        time = -1;

        for (int i = 0; i < M; i++) {
            visited[tmpPos[i][0]][tmpPos[i][1]] = true; // 방문 처리
        }

        while (!queue.isEmpty()) {
            int len = queue.size();

            time++; // 시간 증가

            for (int i = 0; i < len; i++) {
                Virus v = queue.poll();

                int r = v.r; // 현재 행
                int c = v.c; // 현재 열

                for (int d = 0; d < 4; d++) {
                    int nr = r + dr[d]; // 다음 행
                    int nc = c + dc[d]; // 다음 열

                    // 범위를 벗어나거나 방문한 곳, 벽이면 continue
                    if (nr < 0 || nr >= N || nc < 0 || nc >= N || visited[nr][nc] || tmp[nr][nc] == 1) continue;
                    visited[nr][nc] = true; // 방문 처리

                    tmp[nr][nc] = 2; // 시간 갱신

                    queue.add(new Virus(nr, nc));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        pos = new LinkedList<>();
        lab = new int[N][N];
        tmpPos = new int[M][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                lab[i][j] = Integer.parseInt(st.nextToken());
                if (lab[i][j] == 2) pos.add(new Integer[] {i, j});
            }
        }

        min = Integer.MAX_VALUE;

        comb(0, 0);

        if (min == Integer.MAX_VALUE) System.out.println(-1); // 바이러스 활성화 불가능
        else System.out.println(min); // 바이러스 활성화 가능
    }
}