import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Computer implements Comparable<Computer> {
        int to; // 감염 컴퓨터
        int time; // 감염 시간

        Computer (int to, int time) {
            this.to = to;
            this.time = time;
        }

        @Override
        public int compareTo(Computer com) {
            if (this.time > com.time) return 1;
            else if (this.time < com.time) return -1;
            return 0;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken()); // 컴퓨터 개수
            int d = Integer.parseInt(st.nextToken()); // 의존성 개수
            int c = Integer.parseInt(st.nextToken()); // 해킹당한 컴퓨터

            ArrayList<Computer>[] computers = new ArrayList[n + 1];

            for (int i = 1; i <= n; i++) computers[i] = new ArrayList<>();

            for (int i = 0; i < d; i++) {
                st = new StringTokenizer(br.readLine());

                int a = Integer.parseInt(st.nextToken()); // 컴퓨터
                int b = Integer.parseInt(st.nextToken()); // 의존성 컴퓨터
                int s = Integer.parseInt(st.nextToken()); // 감염 시간

                computers[b].add(new Computer(a, s));
            }

            int[] times = new int[n + 1];

            Arrays.fill(times, Integer.MAX_VALUE);

            PriorityQueue<Computer> pq = new PriorityQueue<>();
            pq.add(new Computer(c, 0)); // 시작 컴퓨터 담기
            times[c] = 0;

            while(!pq.isEmpty()) {
                Computer com = pq.poll();

                int curr = com.to; // 현재 컴퓨터
                int time = com.time; // 현재 시간

                for (int i = 0; i < computers[curr].size(); i++) {
                    int next = computers[curr].get(i).to; // 다음 컴퓨터
                    int nTime = computers[curr].get(i).time; // 다음 컴퓨터 감염 시간

                    if (times[next] > time + nTime) {
                        times[next] = time + nTime; // 최솟값 갱신
                        pq.add(new Computer(next, times[next])); // 감염
                    }
                }
            }

            int cnt = 0; // 감염된 컴퓨터 개수
            int time = 0; // 감염 시간

            for (int i = 1; i <= n; i++) {
                if (times[i] == Integer.MAX_VALUE) continue;
                time = Math.max(time, times[i]);
                cnt++;
            }

            sb.append(cnt + " " + time).append("\n");
        }

        System.out.println(sb);
    }
}