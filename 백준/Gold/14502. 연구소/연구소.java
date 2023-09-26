import java.io.*;
import java.util.*;

public class Main {
    static class Virus { // 바이러스 객체 생성 클래스
        int r;
        int c;

        Virus(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static Queue<Virus> queue; // BFS 큐
    static boolean[][] visited; // 방문 체크
    static int[][] restore; // 연구소 복구
    static int[][] lab; // 연구소
    static int[] dr = { -1, 0, 1, 0 }; // 행 탐색
    static int[] dc = { 0, 1, 0, -1 }; // 열 탐색
    static int max; // 안전 영역 최댓값
    static int N; // 세로 크기
    static int M; // 가로 크기

    static void BFS() {
        visited = new boolean[N][M];
        int empty = 0;
        while (!queue.isEmpty()) {
            Virus v = queue.poll();
            int r = v.r;
            int c = v.c;
            visited[r][c] = true; // 방문 체크

            for (int d = 0; d < 4; d++) {
                int rr = r + dr[d];
                int rc = c + dc[d];
                if (rr < 0 || rc < 0 || rr >= N || rc >= M || visited[rr][rc] || lab[rr][rc] == 1)
                    continue;
                if (lab[rr][rc] == 0) lab[rr][rc] = 3; // 바이러스 활성화
                queue.add(new Virus(rr, rc)); // 활성화 영역 큐에 넣기
            }
        }

        // 안전 영역 확인 및 연구소 복원
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (lab[i][j] == 0) empty++;
                if (lab[i][j] == 2) queue.add(new Virus(i, j));
                lab[i][j] = restore[i][j];
            }
        }

        max = Math.max(max, empty); // 안전 영역 최댓값 구하기
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        queue = new LinkedList<>();
        restore = new int[N][M];
        lab = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                lab[i][j] = Integer.parseInt(st.nextToken());
                restore[i][j] = lab[i][j];
                if (lab[i][j] == 2) queue.add(new Virus(i, j));
            }
        }

        // 벽 세우기
        for (int i = 0; i < N * M - 2; i++) {
            for (int j = i + 1; j < N * M - 1; j++) {
                for (int k = j + 1; k < N * M; k++) {
                    if (lab[i / M][i % M] == 0 && lab[j / M][j % M] == 0 && lab[k / M][k % M] == 0) {
                        lab[i / M][i % M] = lab[j / M][j % M] = lab[k / M][k % M] = 1;
                        BFS();
                    }
                }
            }
        }

        System.out.println(max);
    }
}