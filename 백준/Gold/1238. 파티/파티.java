import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class City implements Comparable<City>  {
        int curr;
        int dist;

        City (int curr, int dist) {
            this.curr = curr;
            this.dist = dist;
        }

        @Override
        public int compareTo(City c) {
            if (this.dist > c.dist) return 1;
            else if (this.dist < c.dist) return -1;
            return 0;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        ArrayList<City>[] roads = new ArrayList[N + 1];
        int[][] dists = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) roads[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int A = Integer.parseInt(st.nextToken()); // 시작 도시
            int B = Integer.parseInt(st.nextToken()); // 도착 도시
            int T = Integer.parseInt(st.nextToken()); // 소요 시간

            roads[A].add(new City(B, T)); // 단방향 도로
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (i == j) continue;
                dists[i][j] = Integer.MAX_VALUE; // MAX값 초기화
            }
        }

        for (int i = 1; i <= N; i++) {
            PriorityQueue<City> pq = new PriorityQueue<>();

            pq.add(new City(i, 0));
            dists[i][i] = 0;

            while (!pq.isEmpty()) {
                City c = pq.poll();
                int curr = c.curr; // 현재 도시
                int dist = c.dist; // 현재 거리

                if (dists[i][curr] < dist) continue;

                for (int j = 0; j < roads[curr].size(); j++) {
                    int next = roads[curr].get(j).curr; // 다음 도시
                    int nDist = roads[curr].get(j).dist; // 다음 도시까지 거리

                    if (dists[i][next] > dist + nDist) { // 최솟값 갱신
                        dists[i][next] = dist + nDist;
                        pq.add(new City(next, dists[i][next]));
                    }
                }
            }
        }

        int max = 0; // 최대 거리

        for (int i = 1; i <= N; i++) {
            max = Math.max(max, dists[i][K] + dists[K][i]);
        }

        System.out.println(max);
    }
}