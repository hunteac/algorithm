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

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int[] dr = { -1, 0, 1, 0 }; // 행 탐색
        int[] dc = { 0, 1, 0, -1 }; // 열 탐색
        int T = 1; // 테스트 케이스

        while (true) {
            int N = Integer.parseInt(br.readLine()); // 크기
            if (N == 0) break; // 입력값이 0이면 종료

            int[][] map = new int[N][N];
            int[][] dp = new int[N][N];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    dp[i][j] = Integer.MAX_VALUE;
                }
            }

            Queue<Pos> queue = new LinkedList<>();

            dp[0][0] = map[0][0]; // 출발 위치
            queue.add(new Pos(0, 0));

            while (!queue.isEmpty()) {
                Pos p = queue.poll(); // 현재 위치
                int r = p.r; // 현재 행
                int c = p.c; // 현재 열

                for (int d = 0; d < 4; d++) {
                    int nr = r + dr[d]; // 다음 행
                    int nc = c + dc[d]; // 다음 열

                    if (nr < 0 || nr >= N || nc < 0 || nc >= N) continue; // 범위를 벗어나면 continue

                    if (dp[r][c] + map[nr][nc] < dp[nr][nc]) { // 각 위치별 최솟값 구하기
                        dp[nr][nc] = dp[r][c] + map[nr][nc]; // 값 갱신
                        queue.add(new Pos(nr, nc)); // 값이 더 작은 경우만 큐에 담기
                    }
                }
            }

            sb.append("Problem " + T + ": " + dp[N - 1][N - 1]).append("\n");

            T++;
        }

        System.out.println(sb);
    }
}