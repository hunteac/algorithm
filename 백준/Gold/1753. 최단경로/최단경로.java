import javax.xml.soap.Node;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Node {
        int v; // 다음 노드
        int w; // 가중치

        Node (int v, int w) {
            this.v = v;
            this.w = w;
        }
    }

    static final int INF = 987654321;
    static PriorityQueue<Node> queue; // 노드 우선순위 큐
    static List<Node>[] adjList; // 인접리스트
    static int[] dist; // 노드별 최단경로
    static int V; // 정점
    static int E; // 간선
    static int start; // 시작 정점

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(br.readLine());

        // 가중치를 기준으로 오름차순 정렬
        queue = new PriorityQueue<>(new Comparator<Node>() {
           @Override
           public int compare (Node o1, Node o2) {
               return o1.w - o2.w;
           }
        });

        adjList = new ArrayList[V + 1];
        dist = new int[V + 1];

        for (int i = 1; i <= V; i++) {
            adjList[i] = new ArrayList<>();
        }

        Arrays.fill(dist, INF);

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            adjList[u].add(new Node(v, w));
        }

        dijkstra();

        for (int i = 1; i <= V; i++) {
            if (dist[i] == INF) System.out.println("INF");
            else System.out.println(dist[i]);
        }
    }
    // 다익스트라 알고리즘으로 최단 경로 구하기
    static void dijkstra() {
        boolean[] visited = new boolean[V + 1];
        queue.add(new Node(start, 0)); // 시작 정점
        dist[start] = 0; // 시작 정점의 경로는 0

        while (!queue.isEmpty()) {
            Node curr = queue.poll(); // 현재 정점
            int v = curr.v;

            if (visited[v]) continue; // 방문 체크
            visited[v] = true;

            for (int i = 0; i < adjList[v].size(); i++) {
                Node next = adjList[v].get(i); // 연결된 다음 정점

                if (dist[next.v] > dist[v] + next.w) { // 간선의 가중치가 더 작다면 값 갱신
                    dist[next.v] = dist[v] + next.w;
                    queue.add(new Node(next.v, dist[next.v]));
                }
            }
        }
    }
}