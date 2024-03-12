import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static boolean[][] visited; // 방문 체크
    static int[][] newMap; // 섬을 구분짓는 지도
    static int[][] map; // 지도
    static int[] dr = { -1, 0, 1, 0 }; // 행 탐색
    static int[] dc = { 0, 1, 0, -1 }; // 열 탐색
    static int N; // 크기

    // 섬 구분짓기
    static void chkIsland(int r, int c, int num) {
        newMap[r][c] = num;

        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];
            if (nr < 0 || nr >= N || nc < 0 || nc >= N || visited[nr][nc] || map[nr][nc] == 0) continue;

            visited[nr][nc] = true;

            chkIsland(nr, nc, num);
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visited = new boolean[N][N];
        newMap = new int[N][N];

        int num = 1;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (visited[i][j] || map[i][j] == 0) continue;
                chkIsland(i, j, num);
                num++;
            }
        }

        ArrayList<Integer[]>[] lists = new ArrayList[num];

        for (int i = 1; i < num; i++) lists[i] = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (newMap[i][j] == 0) continue;
                lists[newMap[i][j]].add(new Integer[]{i, j}); // 각 섬 부분좌표 구하기
            }
        }

        int min = Integer.MAX_VALUE;

        // 각 섬 부분 좌표들의 절댓값 차이를 활용해 최소 거리 구하기
        for (int i = 1; i < num - 1; i++) {
            for (int j = i + 1; j < num; j++) {
                for (int r = 0; r < lists[i].size(); r++) {
                    for (int c = 0; c < lists[j].size(); c++) {
                        int firstRIdx = lists[i].get(r)[0];
                        int firstCIdx = lists[i].get(r)[1];
                        int secondRIdx = lists[j].get(c)[0];
                        int secondCIdx = lists[j].get(c)[1];

                        min = Math.min(min, Math.abs(firstRIdx - secondRIdx) + Math.abs(firstCIdx - secondCIdx) - 1);
                    }
                }
            }
        }

        System.out.println(min);
    }
}