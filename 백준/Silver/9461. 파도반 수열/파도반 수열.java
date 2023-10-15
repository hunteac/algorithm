import java.io.*;

public class Main {
    static long[] P; // 파도반 수열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        P = new long[101];

        P[1] = P[2] = P[3] = 1;
        P[4] = P[5] = 2;

        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine());

            if (P[N] != 0) {
                sb.append(P[N]).append("\n");
                continue;
            }

            for (int i = 6; i <= N; i++) {
                P[i] = P[i - 5] + P[i - 1];
            }

            sb.append(P[N]).append("\n");
        }

        System.out.println(sb);
    }
}