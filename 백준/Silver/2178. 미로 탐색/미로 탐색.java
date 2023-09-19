import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static class Node { // Node 객체 생성 클래스
        int x; // x 좌표
        int y; // y 좌표
        int dist; // 현재 거리
        Node(int y, int x, int dist) {
            this.y = y;
            this.x = x;
            this.dist = dist;
        }
    }
    public static Queue<Node> queue; // BFS 큐
    public static boolean[][] maze; // 미로
    public static boolean[][] visited; // 방문 체크
    public static int[] dr = { -1, 0, 1, 0 };
    public static int[] dc = { 0, 1, 0, -1 };
    public static int N; // 세로 크기
    public static int M; // 가로 크기
    public static int min = 0; // 최단 경로

    // BFS (너비 우선 탐색) 메소드
    public static void BFS(int i, int j, int cnt) {
        visited[i][j] = true; // 시작 정점 방문
        queue.add(new Node(i, j, cnt + 1)); // Node 객체 생성 후 큐에 담기

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int x = node.x;
            int y = node.y;
            int dist = node.dist;
            if (y == N - 1 && x == M - 1) { // 목표 지점 도착
                min = dist;
                break;
            }
            for (int d = 0; d < 4; d++) {
                if (x + dc[d] >= 0 && y + dr[d] >= 0 && x + dc[d] < M && y + dr[d] < N) {
                    if (!maze[y + dr[d]][x + dc[d]] || visited[y + dr[d]][x + dc[d]]) continue; // 갈 수 없거나 이미 방문했으면 continue
                    visited[y + dr[d]][x + dc[d]] = true; // 방문 체크
                    queue.add(new Node(y + dr[d], x + dc[d], dist + 1));
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        queue = new LinkedList<>();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        maze = new boolean[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                if (s.charAt(j) == '1') maze[i][j] = true;
            }
        }
        BFS(0 ,0, 0);
        System.out.println(min);
    }
}