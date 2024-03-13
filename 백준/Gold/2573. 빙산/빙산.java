import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static boolean[][] visited; // 방문 체크
    static int[][] curr; // 현재 빙하 정보
    static int[][] after; // 다음 빙하 정보
    static int[] dr = { -1, 0, 1, 0 }; // 행 탐색
    static int[] dc = { 0, 1, 0, -1 }; // 열 탐색
    static int N; // 행 크기
    static int M; // 열 크기

    static void chk (int r, int c) {
        visited[r][c] = true; // 방문 처리

        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d]; // 다음 좌표
            int nc = c + dc[d];
            if (visited[nr][nc]) continue;
            if (curr[nr][nc] == 0) {
                if (after[r][c] > 0) after[r][c] -= 1; // 바닷물에 접해있는 빙하 녹이기
                continue;
            }

            chk(nr, nc);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        curr = new int[N][M];
        after = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                curr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int cnt; // 빙하 개수
        int day = 0; // 시간

        while (true) {
            cnt = 0;
            visited = new boolean[N][M];

            after = curr.clone();

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    // 빙하 덩어리 탐색
                    if (curr[i][j] == 0 || visited[i][j]) continue;

                    chk(i, j);

                    cnt++; // 빙하 덩어리 추가
                }
            }

            if (cnt == 0 || cnt > 1) break;

            curr = after.clone(); // 빙하 갱신

            day++;
        }

        if (cnt != 0) System.out.println(day); // 분리
        else System.out.println(cnt); // 분리 X
    }
}