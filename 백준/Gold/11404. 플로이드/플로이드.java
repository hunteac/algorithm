import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        int[][] bus = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) continue;
                bus[i][j] = Integer.MAX_VALUE;
            }
        }

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken()); // 출발 도시
            int b = Integer.parseInt(st.nextToken()); // 도착 도시
            int c = Integer.parseInt(st.nextToken()); // 비용

            bus[a][b] = Math.min(bus[a][b], c);
        }

        // 플로이드 와샬 알고리즘
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (bus[i][k] == Integer.MAX_VALUE || bus[k][j] == Integer.MAX_VALUE) continue; // 이동 불가
                    if (bus[i][j] > bus[i][k] + bus[k][j]) {
                        bus[i][j] = bus[i][k] + bus[k][j];
                    }
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (bus[i][j] == Integer.MAX_VALUE) System.out.print(0 + " "); // 이동 불가
                else System.out.print(bus[i][j] + " ");
            }
            System.out.println();
        }
    }
}