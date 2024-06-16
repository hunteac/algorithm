import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        char[][] map = new char[R][C];

        for (int r = 0; r < R; r++) {
            String part = br.readLine();
            for (int c = 0; c < C; c++) {
                map[r][c] = part.charAt(c);
            }
        }

        ArrayList<Integer[]> place = new ArrayList<>(); // 남는 섬 좌표
        int[] dr = { -1, 0, 1, 0 }; // 행 탐색
        int[] dc = { 0, 1, 0, -1 }; // 열 탐색
        int minR = 10; // 최소 행
        int maxR = 0; // 최대 행
        int minC = 10; // 최소 열
        int maxC = 0; // 최대 열

        for (int r = 0; r < R; r++) {
            Outer: for (int c = 0; c < C; c++) {
                if (map[r][c] == '.') continue;
                int cnt = 0;
                for (int d = 0; d < 4; d++) {
                    int nr = r + dr[d];
                    int nc = c + dc[d];
                    if (nr < 0 || nr >= R || nc < 0 || nc >= C || map[nr][nc] == '.') cnt++;
                    if (cnt == 3) continue Outer;
                }
                minR = Math.min(minR, r);
                maxR = Math.max(maxR, r);
                minC = Math.min(minC, c);
                maxC = Math.max(maxC, c);
                place.add(new Integer[]{r, c});
            }
        }

        for (int r = minR; r <= maxR; r++) { // 남아있는 섬 지도 그리기
            for (int c = minC; c <= maxC; c++) {
                if (!place.isEmpty()) {
                    if (r == place.get(0)[0] && c == place.get(0)[1]) {
                        sb.append("X");
                        place.remove(0);
                        continue;
                    }
                    sb.append(".");
                } else {
                    sb.append(".");
                }
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
