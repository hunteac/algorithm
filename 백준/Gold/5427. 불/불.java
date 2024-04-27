import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        Outer: for (int tc = 0; tc < T; tc++) {
            st = new StringTokenizer(br.readLine());

            int W = Integer.parseInt(st.nextToken()); // 너비
            int H = Integer.parseInt(st.nextToken()); // 높이

            char[][] map = new char[H][W]; // 빌딩 지도
            boolean[][] fVisited = new boolean[H][W]; // 불 방문 체크
            boolean[][] sVisited = new boolean[H][W]; // 상근이 방문 체크
            int[][] fire = new int[H][W]; // 구간별 불이 난 시간
            int[] dr = { -1, 0, 1, 0 };
            int[] dc = { 0, 1, 0, -1 };
            Queue<Integer[]> fq = new LinkedList<>();
            Queue<Integer[]> sq = new LinkedList<>();

            for (int i = 0; i < H; i++) Arrays.fill(fire[i], Integer.MAX_VALUE);

            for (int i = 0; i < H; i++) {
                String str = br.readLine();
                for (int j = 0; j < W; j++) {
                    map[i][j] = str.charAt(j);
                    if (map[i][j] == '*') { // 불 위치
                        fire[i][j] = 0;
                        fq.add(new Integer[]{i, j});
                        fVisited[i][j] = true;
                    } else if (map[i][j] == '@') { // 상근이 위치
                        sq.add(new Integer[]{i, j});
                        sVisited[i][j] = true;
                    }
                }
            }

            int cnt = 1;
            while (!fq.isEmpty()) { // 불 붙이기
                int len = fq.size();

                for (int i = 0; i < len; i++) {
                    Integer[] pos = fq.poll(); // 현재 불 위치
                    int r = pos[0]; // 행
                    int c = pos[1]; // 열

                    for (int d = 0; d < 4; d++) {
                        int nr = r + dr[d];
                        int nc = c + dc[d];
                        // 범위 벗어남 OR 벽 OR 이미 불이 붙은 공간은 continue
                        if (nr < 0 || nr >= H || nc < 0 || nc >= W || map[nr][nc] == '#' || fVisited[nr][nc]) continue;

                        fVisited[nr][nc] = true; // 방문 처리
                        fire[nr][nc] = cnt; // 불이 붙은 시간
                        fq.add(new Integer[]{nr, nc});
                    }
                }

                cnt++;
            }

            cnt = 1;
            boolean chk = false; // 탈출 여부
            while (!sq.isEmpty()) { // 상근이 탈출
                int len = sq.size();

                for (int i = 0; i < len; i++) {
                    Integer[] pos = sq.poll(); // 현재 상근이 위치
                    int r = pos[0]; // 행
                    int c = pos[1]; // 열

                    for (int d = 0; d < 4; d++) {
                        int nr = r + dr[d];
                        int nc = c + dc[d];
                        if (nr < 0 || nr >= H || nc < 0 || nc >= W) { // 탈출
                            sb.append(cnt).append("\n");
                            continue Outer;
                        }
                        // 벽 OR 불이 붙은 공간 OR 이미 방문한 공간은 continue
                        if (map[nr][nc] == '#' || fire[nr][nc] <= cnt || sVisited[nr][nc]) continue;

                        sVisited[nr][nc] = true; // 방문 처리
                        sq.add(new Integer[]{nr, nc});
                    }
                }

                cnt++;
            }

            if (!chk) sb.append("IMPOSSIBLE").append("\n"); // 탈출 불가능
        }

        System.out.println(sb);
    }
}