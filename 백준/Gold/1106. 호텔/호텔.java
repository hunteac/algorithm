import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static class Curr implements Comparable<Curr> {
        int cost;
        int num;

        Curr(int cost, int num) {
            this.cost = cost;
            this.num = num;
        }

        @Override
        public int compareTo(Curr curr) {
            return this.cost == curr.cost ? curr.num - this.num : this.cost - curr.cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int C = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        PriorityQueue<Curr> pq = new PriorityQueue<>();
        int[][] city = new int[N][2];
        int[] max = new int[100001];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int cost = Integer.parseInt(st.nextToken()); // 비용
            int num = Integer.parseInt(st.nextToken()); // 고객의 수

            pq.add(new Curr(cost, num));
            city[i][0] = cost;
            city[i][1] = num;
        }

        while (!pq.isEmpty()) {
            Curr curr = pq.poll();

            int cost = curr.cost;
            int num = curr.num;

            if (num >= C) {
                System.out.println(cost);
                return;
            }

            for (int i = 0; i < N; i++) {
                if (num + city[i][1] > max[cost + city[i][0]]) {
                    max[cost + city[i][0]] = num + city[i][1];
                    pq.add(new Curr(cost + city[i][0], num + city[i][1]));
                }
            }
        }
    }
}