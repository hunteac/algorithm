import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static ArrayList<Integer>[] graph; // 인접 리스트
    public static Queue<Integer> queue; // BFS 큐
    public static boolean[] visited; // 방문 확인 배열
    public static int[] order; // 방문 순서 배열
    public static int cnt; // 방문 순서
    public static int N; // 정점 수
    public static int M; // 간선 수
    // BFS (너비 우선 탐색) 메소드
    public static void BFS(int v) {
        visited[v] = true; // 시작 정점 방문
        queue.add(v); // 시작 정점 담기
        while (!queue.isEmpty()) {
            int t = queue.poll();
            order[t] = cnt++; // 방문 순서 담기
            for (int nextNode : graph[t]) {
                if (visited[nextNode]) continue;
                visited[nextNode] = true;
                queue.add(nextNode);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        graph = new ArrayList[N + 1];
        queue = new LinkedList<>();
        visited = new boolean[N + 1];
        order = new int[N + 1];
        cnt = 1;
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
        for (int i = 1; i < N + 1; i++) { // 내림차순 정렬
            Collections.sort(graph[i], (o1, o2) -> (o2 - o1));
        }
        BFS(R);
        for (int i = 1; i < N + 1; i++) {
            sb.append(order[i]).append("\n");
        }
        System.out.println(sb);
    }
}