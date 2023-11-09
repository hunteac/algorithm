import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Node {
        int to;
        int fee;
        Node (int to, int fee) {
            this.to = to;
            this.fee = fee;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine()); // 도시 수
        int M = Integer.parseInt(br.readLine()); // 간선 수

        List<Node>[] edges = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) edges[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken()); // 출발 도시
            int to = Integer.parseInt(st.nextToken()); // 도착 도시
            int fee = Integer.parseInt(st.nextToken()); // 비용

            edges[from].add(new Node(to, fee));
        }

        int[] fee = new int[N + 1]; // 최소 비용 정보를 담는 배열

        Arrays.fill(fee, Integer.MAX_VALUE);

        st = new StringTokenizer(br.readLine());

        int start = Integer.parseInt(st.nextToken()); // 출발 도시
        int end = Integer.parseInt(st.nextToken()); // 도착 도시

        PriorityQueue<Node> pq = new PriorityQueue<Node>((o1, o2) -> Integer.compare(o1.fee, o2.fee));

        pq.add(new Node(start, 0));

        fee[start] = 0; // 출발 도시의 비용은 0

        // 다익스트라 알고리즘
        while (!pq.isEmpty()) {
            Node curr = pq.poll(); // 현재 도시

            if (fee[curr.to] < curr.fee) continue; // 현재 비용이 최소 비용을 초과하면 continue

            for (int i = 0; i < edges[curr.to].size(); i++) {
                Node next = edges[curr.to].get(i); // 다음 도시

                if (next.to == end) { // 다음 도시가 도착 도시면
                    fee[end] = Math.min(fee[end], curr.fee + next.fee); // 최소 비용 구하기
                    continue;
                }

                if (fee[next.to] > curr.fee + next.fee) { // 다음 도시의 최소 비용이 현재 도시 + 다음 도시의 비용보다 크다면
                    fee[next.to] = curr.fee + next.fee; // 최솟값 갱신
                    pq.add(new Node(next.to, fee[next.to]));
                }
            }
        }

        System.out.println(fee[end]); // 도착 도시까지의 최소 비용 출력
    }
}