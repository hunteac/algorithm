import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < 2 * N - 1; i++) {
            if (i < N) {
                for (int j = 0; j < N; j++) {
                    if (i + j >= N - 1) sb.append("*");
                    else sb.append(" ");
                }
            } else {
                for (int j = 0; j < N; j++) {
                    if (i - j <= N - 1) sb.append("*");
                    else sb.append(" ");
                }
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}