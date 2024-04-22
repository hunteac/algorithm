import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] paper = new int[102][102];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int lx = Integer.parseInt(st.nextToken()); // 왼쪽 모서리
            int ly = Integer.parseInt(st.nextToken());
            int rx = Integer.parseInt(st.nextToken()); // 오른쪽 모서리
            int ry = Integer.parseInt(st.nextToken());

            paper[ly][lx]++;
            paper[ly][rx + 1]--;
            paper[ry + 1][lx]--;
            paper[ry + 1][rx + 1]++;
        }

        // 종이 놓기
        for (int i = 1; i <= 101; i++) {
            for (int j = 1; j <= 101; j++) {
                paper[i][j] += paper[i][j - 1];
            }
        }

        for (int i = 1; i <= 101; i++) {
            for (int j = 1; j <= 101; j++) {
                paper[j][i] += paper[j - 1][i];
            }
        }

        int cnt = 0; // 보이지 않는 그림

        for (int i = 1; i <= 100; i++) {
            for (int j = 1; j <= 100; j++) {
                if (paper[i][j] > M) cnt++;
            }
        }

        System.out.println(cnt);
    }
}
