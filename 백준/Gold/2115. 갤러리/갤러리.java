import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        boolean[][][] visited = new boolean[N][M][4];
        char[][] map = new char[N][M];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j);
            }
        }

        int[] dr = { -1, 0, 1, 0 }; // 행 탐색
        int[] dc = { 0, 1, 0, -1 }; // 열 탐색
        int cnt = 0; // 최대 그림 개수

        for (int r = 1; r < N - 1; r++) {
            for (int c = 1; c < M - 1; c++) {
                if (map[r][c] == 'X') continue; // 현재 공간이 벽이면 continue

                for (int d = 0; d < 4; d++) {
                    int nr = r + dr[d]; // 다음 행
                    int nc = c + dc[d]; // 다음 열

                    if (map[nr][nc] == 'X') continue; // 다음 공간이 벽이면 continue

                    if (d == 0 || d == 2) { // 상, 하
                        if (map[r][c - 1] == 'X' && map[nr][nc - 1] == 'X' && !visited[r][c][3] && !visited[nr][nc][3]) { // 왼벽
                            cnt++;
                            visited[r][c][3] = visited[nr][nc][3] = true; // 방문 처리
//                            System.out.println("r : " + r + " c : " + c + " nr : " + nr + " nc : " + nc + " d : " + d);
                        }
                        if (map[r][c + 1] == 'X' && map[nr][nc + 1] == 'X' && !visited[r][c][1] && !visited[nr][nc][1]) { // 오른벽
                            cnt++;
                            visited[r][c][1] = visited[nr][nc][1] = true; // 방문 처리
                        }
                    } else { // 좌, 우
                        if (map[r - 1][c] == 'X' && map[nr - 1][nc] == 'X' && !visited[r][c][0] && !visited[nr][nc][0]) { // 윗벽
                            cnt++;
                            visited[r][c][0] = visited[nr][nc][0] = true; // 방문 처리
                        }
                        if (map[r + 1][c] == 'X' && map[nr + 1][nc] == 'X' && !visited[r][c][2] && !visited[nr][nc][2]) { // 아랫벽
                            cnt++;
                            visited[r][c][2] = visited[nr][nc][2] = true; // 방문 처리
                        }
                    }
                }
            }
        }

        System.out.println(cnt);
    }
}