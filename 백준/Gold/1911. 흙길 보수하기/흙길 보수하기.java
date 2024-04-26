import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static class Pool implements Comparable<Pool> {
        int start;
        int end;

        Pool (int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Pool o) {
            return this.start - o.start;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        PriorityQueue<Pool> pq = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            pq.add(new Pool(start, end));
        }

        int minCnt = 0; // 널빤지 최소 개수
        int curr = 0;

        while (!pq.isEmpty()) {
            Pool p = pq.poll(); // 현재 물웅덩이

            int start = p.start; // 시작 지점
            int end = p.end; // 끝 지점
            if (start < curr) start = curr; // 겹치는 부분 체크
            if (end < curr) continue;
            int len = end - start; // 물웅덩이 길이
            int cnt; // 필요한 널빤지 개수

            if (len % L == 0) cnt = len / L;
            else cnt = len / L + 1;

            minCnt += cnt;
            curr = start + L * cnt;
        }

        System.out.println(minCnt);
    }
}
