import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static ArrayList<Integer>[] graph; // 인접 리스트
    public static Queue<Integer> queue; // BFS 큐
    public static boolean[] visited; // 방문 확인 배열
    public static StringBuilder sb;
    public static int N; // 정점 수
    public static int M; // 간선 수
    // DFS (깊이 우선 탐색) 메소드
    public static void DFS(int v) {
        visited[v] = true; // 방문 확인
        sb.append(v).append(" ");
        for (int nextNode : graph[v]) {
            if (visited[nextNode]) continue;
            DFS(nextNode);
        }
    }
    // BFS (너비 우선 탐색) 메소드
    public static void BFS(int v) {
        visited[v] = true; // 시작 정점 방문
        queue.add(v);
        while (!queue.isEmpty()) {
            int t = queue.poll();
            sb.append(t).append(" ");
            for (int nextNode : graph[t]) {
                if (visited[nextNode]) continue;
                visited[nextNode] = true;
                queue.add(nextNode);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        queue = new LinkedList<>();
        graph = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        for (int i = 1; i < N + 1; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) { // 인접 정점 담기
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            graph[A].add(B);
            graph[B].add(A);
        }
        for (int i = 1; i < N + 1; i++) { // 오름차순 정렬
            Collections.sort(graph[i]);
        }
        DFS(R);
        sb.append("\n");
        visited = new boolean[N + 1];
        BFS(R);
        System.out.println(sb);
    }
}