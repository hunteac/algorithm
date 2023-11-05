import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());

            int si = Integer.parseInt(st.nextToken()) - 1;
            int sj = Integer.parseInt(st.nextToken()) - 1;
            int ei = Integer.parseInt(st.nextToken()) - 1;
            int ej = Integer.parseInt(st.nextToken()) - 1;

            int sum = 0;

            for (int r = si; r <= ei; r++) {
                for (int c = sj; c <= ej; c++) {
                    sum += arr[r][c];
                }
            }

            sb.append(sum).append("\n");
        }

        System.out.println(sb);
    }
}