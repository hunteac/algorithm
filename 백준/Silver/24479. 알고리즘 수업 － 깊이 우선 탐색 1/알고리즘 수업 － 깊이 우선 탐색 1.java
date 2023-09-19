import java.util.*;

public class Main {
    public static ArrayList<Integer>[] graph; // 인접 리스트
    public static int[] order; // 방문 순서
    public static boolean[] visited; // 방문 확인
    public static int N; // 정점 수
    public static int M; // 간선 수
    public static int cnt = 1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        N = sc.nextInt();
        M = sc.nextInt();
        int R = sc.nextInt(); // 시작 정점
        graph = new ArrayList[N + 1];
        order = new int[N + 1];
        visited = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            int A = sc.nextInt();
            int B = sc.nextInt();
            graph[A].add(B);
            graph[B].add(A);
        }
        for (int i = 1; i < N + 1; i++) {
            Collections.sort(graph[i]);
        }
        DFS(R); // 깊이 우선 탐색
        for (int i = 1; i <= N; i++) {
            sb.append(order[i]).append("\n");
        }
        System.out.println(sb);
    }
    public static void DFS (int v) {
        visited[v] = true; // 방문 처리
        order[v] = cnt++; // 순서 담기
        for (int nextNode : graph[v]) { // 방문하지 않았고, 인접한 정점 오름차순 방문
            if (visited[nextNode]) continue;
            DFS(nextNode);
        }
    }
}