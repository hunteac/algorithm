import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static class Node implements Comparable<Node> {
        int next;
        int dist;

        Node(int next, int dist) {
            this.next = next;
            this.dist = dist;
        }

        public int compareTo(Node o) {
            return this.dist - o.dist;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(br.readLine());

        int[] dists = new int[V + 1];
        Arrays.fill(dists, Integer.MAX_VALUE);

        List<List<Node>> edges = new ArrayList<>();

        for (int i = 0; i <= V; i++) {
            edges.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            edges.get(u).add(new Node(v, w));
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(K, 0));

        while (!pq.isEmpty()) {
            Node node = pq.poll();

            for (Node nextNode : edges.get(node.next)) {
                if (dists[nextNode.next] > node.dist + nextNode.dist) {
                    dists[nextNode.next] = node.dist + nextNode.dist;
                    pq.add(new Node(nextNode.next, dists[nextNode.next]));
                }
            }
        }

        for (int i = 1; i <= V; i++) {
            if (i == K) sb.append(0);
            else if (dists[i] != Integer.MAX_VALUE) sb.append(dists[i]);
            else sb.append("INF");

            sb.append("\n");
        }

        System.out.println(sb);
    }
}