import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static ArrayList<Integer>[] graph; // 인접 리스트
    public static boolean[] visited; // 방문 확인 배열
    public static int cnt; // 감염 컴퓨터 수
    public static int N; // 정점 수
    public static int M; // 간선 수
    // DFS (깊이 우선 탐색) 메소드
    public static void DFS(int v) {
        visited[v] = true;
        cnt++;
        for (int nextNode : graph[v]) {
            if (visited[nextNode]) continue;
            DFS(nextNode);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        graph = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        cnt = 0;
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
        DFS(1);
        System.out.println(cnt - 1); // 1번 컴퓨터 제외
    }
}