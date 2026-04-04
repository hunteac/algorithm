import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        int[][][] map = new int[H][N][M];

        Queue<Integer[]> tomatoes = new LinkedList<>();

        int cnt = 0;

        for (int h = 0; h < H; h++) {
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < M; j++) {
                    map[h][i][j] = Integer.parseInt(st.nextToken());
                    if (map[h][i][j] == 1) {
                        tomatoes.add(new Integer[]{h, i, j});
                    } else if (map[h][i][j] == 0) {
                        cnt++;
                    }
                }
            }
        }

        if (cnt == 0) {
            System.out.println(0);
            return;
        }

        int[] dh = {-1, 1, 0, 0, 0, 0};
        int[] dr = {0, 0, -1, 0, 1, 0};
        int[] dc = {0, 0, 0, 1, 0, -1};

        int days = 0;

        while (!tomatoes.isEmpty()) {
            int len = tomatoes.size();

            for (int i = 0; i < len; i++) {
                Integer[] tomato = tomatoes.poll();
                int h = tomato[0];
                int r = tomato[1];
                int c = tomato[2];

                for (int d = 0; d < 6; d++) {
                    int nh = h + dh[d];
                    int nr = r + dr[d];
                    int nc = c + dc[d];

                    if (nh >= 0 && nh < H && nr >= 0 && nr < N && nc >= 0 && nc < M) {
                        if (map[nh][nr][nc] == 0) {
                            map[nh][nr][nc] = 1;
                            tomatoes.add(new Integer[]{nh, nr, nc});
                        }
                    }
                }
            }

            if (!tomatoes.isEmpty()) {
                days++;
            }
        }

        for (int h = 0; h < H; h++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (map[h][i][j] == 0) {
                        System.out.println(-1);
                        return;
                    }
                }
            }
        }

        System.out.println(days);
    }
}