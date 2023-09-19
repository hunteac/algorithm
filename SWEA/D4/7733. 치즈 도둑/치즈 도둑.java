import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Solution {
    public static int[][] cheeze;
    public static boolean[][] visited; // 방문 체크
    public static int[] dr = { -1, 0, 1, 0 };
    public static int[] dc = { 0, 1, 0, -1 };
    public static int N; // 치즈 길이
    public static int max; // 최대 덩어리 개수
    // DFS (깊이 우선 탐색) 메소드
    public static void DFS(int y, int x, int day) {
        visited[y][x] = true; // 방문

        for (int d = 0; d < 4; d++) { // 탐색
            int r = y + dr[d];
            int c = x + dc[d];
            if (r >= 0 && c >= 0 && r < N && c < N) { // 치즈 범위 내에서만
                if (visited[r][c] || cheeze[r][c] <= day) continue; // 방문했거나 이미 먹은 치즈 continue
                DFS(r, c, day);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
            cheeze = new int[N][N];
            max = Integer.MIN_VALUE;
            int maxNum = Integer.MIN_VALUE;
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    cheeze[i][j] = Integer.parseInt(st.nextToken());
                    maxNum = Math.max(maxNum, cheeze[i][j]);
                }
            }
            for (int i = 0; i < maxNum; i++) {
                int num = 0;
                visited = new boolean[N][N];
                for (int j = 0; j < N; j++) {
                    for (int k = 0; k < N; k++) {
                        if (cheeze[j][k] > i && !visited[j][k]) {
                            DFS(j, k, i);
                            num++;
                        }
                    }
                }
                max = Math.max(max, num);
            }
            System.out.println("#" + tc + " " + max);
        }
    }
}