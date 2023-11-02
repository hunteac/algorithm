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

        st = new StringTokenizer(br.readLine());

        int[] sum = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            sum[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= N; i++) { // 누적합 구하기
            sum[i] += sum[i - 1];
        }

        for (int i = 0; i < M; i++) { // 구간 합 구하기
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken()); // 구간 시작
            int end = Integer.parseInt(st.nextToken()); // 구간 끝

            sb.append(sum[end] - sum[start - 1]).append("\n");
        }

        System.out.println(sb);
    }
}