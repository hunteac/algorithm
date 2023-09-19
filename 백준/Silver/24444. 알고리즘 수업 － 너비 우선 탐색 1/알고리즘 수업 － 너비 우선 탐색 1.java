import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static ArrayList<Integer>[] graph; // 인접 리스트
    public static Queue<Integer> queue = new LinkedList<>(); // BFS 큐
    public static boolean[] visited; // 방문 확인
    public static int[] order; // 방문 순서 배열
    public static int cnt = 1; // 방문 순서
    public static int N; // 정점 수
    public static int M; // 간선 수

    public static void BFS(int v) {
        queue.add(v); // 시작 정점 담기
        visited[v] = true; // 시작 정점 방문
        while (!queue.isEmpty()) {
            int t = queue.poll();
            order[t] = cnt++; // 방문 순서 담기
            for (int nextNode : graph[t]) {
                if (visited[nextNode]) continue;
                visited[nextNode] = true; // 방문 확인
                queue.add(nextNode); // 인접 정점 담기
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken()); // 시작 정점
        graph = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        order = new int[N + 1];
        for (int i = 1; i < N + 1; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) { // 인접 정보 입력
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            graph[A].add(B);
            graph[B].add(A);
        }
        for (int i = 1; i < N + 1; i++) { // 오름차순 정렬
            Collections.sort(graph[i]);
        }
        BFS(R);
        for (int i = 1; i < N + 1; i++) {
            sb.append(order[i]).append("\n");
        }
        System.out.println(sb);
    }
}