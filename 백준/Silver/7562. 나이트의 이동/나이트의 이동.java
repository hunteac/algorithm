import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static class Night { // 나이트 객체 생성 클래스
        int x;
        int y;
        int cnt;
        Night (int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }

    static Queue<Night> queue;
    static int[] dr = { 2, 1, -1, -2, -2, -1, 1, 2 };
    static int[] dc = { 1, 2, 2, 1, -1, -2, -2, -1 };
    static boolean[][] visited; // 방문 체크
    static int N; // 체스판 길이
    static int tx; // 목표 x좌표
    static int ty; // 목표 y좌표

    // BFS (너비 우선 탐색) 메소드
    static int BFS(int x, int y) {
        visited[x][y] = true;
        queue.add(new Night(x, y, 0));

        while (!queue.isEmpty()) {
            Night night = queue.poll();
            int cx = night.x;
            int cy = night.y;
            int count = night.cnt;
            if (cx == tx && cy == ty)  {
                return count; // 최소 이동 횟수 반환
            }

            for (int d = 0; d < 8; d++) {
                int rc = cx + dc[d];
                int rr = cy + dr[d];
                if (rc < 0 || rr < 0 || rc >= N || rr >= N || visited[rc][rr]) continue;
                visited[rc][rr] = true;
                queue.add(new Night(rc, rr, count + 1));
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            queue = new LinkedList<>();
            N = sc.nextInt();
            int x = sc.nextInt(); // 시작 x좌표
            int y = sc.nextInt(); // 시작 y좌표
            tx = sc.nextInt();
            ty = sc.nextInt();
            visited = new boolean[N][N];
            sb.append(BFS(x, y)).append("\n");
        }
        System.out.println(sb);
    }
}