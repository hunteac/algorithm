import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        int[][] map = new int[N][N];
        char[][] answer = new char[N][N];
        int[] dr = { -1, -1, -1, 0, 1, 1, 1, 0 };
        int[] dc = { -1, 0, 1, 1, 1, 0, -1, -1 };

        for (int r = 0; r < N; r++) {
            String str = br.readLine();
            for (int c = 0; c < N; c++) {
                char curr = str.charAt(c);

                if (curr == '.') continue;

                answer[r][c] = '*'; // 지뢰

                for (int d = 0; d < 8; d++) {
                    int nr = r + dr[d];
                    int nc = c + dc[d];
                    if (nr < 0 || nr >= N || nc < 0 || nc >= N) continue;

                    map[nr][nc] += curr - '0';
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (answer[i][j] == '*') continue; // 지뢰
                int curr = map[i][j];

                if (curr >= 10) answer[i][j] = 'M'; // 10이상
                else answer[i][j] = Character.forDigit(map[i][j], 10); // 10미만
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(answer[i][j]);
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
