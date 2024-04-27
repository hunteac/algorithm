import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] things = new int[N + 1][2]; // 물건
        int[][] bag = new int[N + 1][K + 1]; // 가방

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());

            int W = Integer.parseInt(st.nextToken()); // 무게
            int V = Integer.parseInt(st.nextToken()); // 가치

            things[i][0] = W;
            things[i][1] = V;
        }

        for (int i = 1; i <= N; i++) {
            int W = things[i][0];
            int V = things[i][1];
            for (int j = 1; j <= K; j++) { // 무게
                if (j < W) bag[i][j] = bag[i - 1][j]; // 무게 초과
                else bag[i][j] = Math.max(bag[i - 1][j], bag[i - 1][j - W] + V); // 안담기 OR 빼고 담기 OR 담기 최댓값 갱신
            }
        }

        System.out.println(bag[N][K]); // 최대 가치
    }
}