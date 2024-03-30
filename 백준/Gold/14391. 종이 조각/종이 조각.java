import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] paper;
    static int N, M, max;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        paper = new int[N][M];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                paper[i][j] = str.charAt(j) - '0';
            }
        }

        max = 0;

        // 비트마스킹 활용 (가로 == 0, 세로 == 1)
        for (int i = 0; i < (1 << (N * M)); i++) {
            int sum = 0;
            // 가로 찾기
            for (int r = 0; r < N; r++) {
                int curr = 0;
                for (int c = 0; c < M; c++) {
                    int k = r * M + c;
                    if ((i & (1 << k)) == 0) { // 가로에 해당
                        curr *= 10;
                        curr += paper[r][c];
                    } else { // 세로에 해당
                        sum += curr;
                        curr = 0;
                    }
                }
                sum += curr;
            }

            // 세로 찾기
            for (int c = 0; c < M; c++) {
                int curr = 0;
                for (int r = 0; r < N; r++) {
                    int k = r * M + c;
                    if ((i & (1 << k)) != 0) { // 세로에 해당
                        curr *= 10;
                        curr += paper[r][c];
                    } else { // 가로에 해당
                        sum += curr;
                        curr = 0;
                    }
                }
                sum += curr;
            }
            // 최댓값 갱신
            max = Math.max(max, sum);
        }

        System.out.println(max);
    }
}