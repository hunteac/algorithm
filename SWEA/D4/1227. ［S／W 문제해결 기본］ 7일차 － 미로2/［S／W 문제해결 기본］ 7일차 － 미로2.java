import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    static int[][] maze; // 미로
    static boolean[][] visited; // 방문 체크
    static int[] dr = { -1, 0, 1, 0 }; // r 탐색 배열
    static int[] dc = { 0, 1, 0, -1 }; // c 탐색 배열
    static int ans; // 도달 가능 여부

    // DFS (깊이 우선 탐색) 메소드
    static void DFS(int r, int c) {
        if (maze[r][c] == 3) { // 도착점 도달
            ans = 1;
            return;
        }

        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];
            if (nr < 0 || nc < 0 || nr >= 100 || nc >= 100 || visited[nr][nc] || maze[nr][nc] == 1) continue;
            visited[nr][nc] = true;
            DFS(nr, nc);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int tc = 1; tc <= 10; tc++) {
            int N = Integer.parseInt(br.readLine()); // 테스트 케이스 번호
            maze = new int[100][100];
            visited = new boolean[100][100];
            ans = 0;

            for (int i = 0; i < 100; i++) {
                String s = br.readLine();
                for (int j = 0; j < 100; j++) {
                    maze[i][j] = s.charAt(j) - '0';
                }
            }

            for (int i = 0; i < 100; i++) {
                for (int j = 0; j < 100; j++) {
                    if (maze[i][j] == 2) {
                        DFS(i, j); // 출발 지점에 도착하면 탐색 시작
                        break;
                    }
                }
            }

            System.out.println("#" + N + " " + ans);
        }
    }
}