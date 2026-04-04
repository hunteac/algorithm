import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static class Virus implements Comparable<Virus> {
        int r;
        int c;
        int num;
        int time;

        Virus(int r, int c, int num, int time) {
            this.r = r;
            this.c = c;
            this.num = num;
            this.time = time;
        }

        @Override
        public int compareTo(Virus o) {
            if (this.time != o.time) {
                return Integer.compare(this.time, o.time);
            } else {
                return Integer.compare(this.num, o.num);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][N];

        PriorityQueue<Virus> pq = new PriorityQueue();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] != 0) {
                    pq.add(new Virus(i, j, map[i][j], 0));
                }
            }
        }

        st = new StringTokenizer(br.readLine());

        int S = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());

        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};

        while (!pq.isEmpty()) {
            Virus v = pq.poll();
            int r = v.r;
            int c = v.c;
            int num = v.num;
            int time = v.time;

            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];
                if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
                    if (map[nr][nc] == 0 && time + 1 <= S) {
                        map[nr][nc] = num;
                        pq.add(new Virus(nr, nc, num, time + 1));
                    }
                }
            }
        }

        System.out.println(map[X - 1][Y - 1]);
    }
}