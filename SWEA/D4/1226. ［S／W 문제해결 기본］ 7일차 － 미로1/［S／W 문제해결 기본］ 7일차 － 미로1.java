import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    static class Pos { // 현재 위치 정보를 나타내는 객체 생성 클래스
        int r;
        int c;
        Pos (int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static Queue<Pos> queue; // BFS 큐
    static int[][] maze; // 미로
    static boolean[][] visited; // 방문 체크
    static int[] dr = { -1, 0, 1, 0 }; // r 탐색 배열
    static int[] dc = { 0, 1, 0, -1 }; // c 탐색 배열
    static int ans; // 도달 가능 여부

    // BFS (너비 우선 탐색) 메소드
    static void BFS(int r, int c) {
        visited[r][c] = true; // 방문 처리
        queue.add(new Pos(r, c));

        while (!queue.isEmpty()) {
            Pos pos = queue.poll();
            int cr = pos.r;
            int cc = pos.c;
            if (maze[cr][cc] == 3) { // 도착점 도달
                ans = 1;
                return;
            }

            for (int d = 0; d < 4; d++) {
                int rr = cr + dr[d];
                int rc = cc + dc[d];
                if (rr < 0 || rc < 0 || rr >= 16 || rc >= 16 || maze[rr][rc] == 1 || visited[rr][rc])
                    continue;
                visited[rr][rc] = true; // 방문 처리
                queue.add(new Pos(rr, rc));
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int tc = 1; tc <= 10; tc++) {
            int N = Integer.parseInt(br.readLine()); // 테스트 케이스 번호
            queue = new LinkedList<>();
            maze = new int[16][16];
            visited = new boolean[16][16];
            ans = 0; // 도달 가능 여부

            for (int i = 0; i < 16; i++) {
                String s = br.readLine();
                for (int j = 0; j < 16; j++) {
                    maze[i][j] = s.charAt(j) - '0';
                }
            }

            for (int i = 0; i < 16; i++) {
                for (int j = 0; j < 16; j++) {
                    if (maze[i][j] == 2) BFS(i, j); // 출발 지점에 도착하면 탐색 시작
                }
            }

            System.out.println("#" + N + " " + ans);
        }
    }
}