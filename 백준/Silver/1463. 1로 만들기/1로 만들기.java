import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] cnts = new int[N + 1];

        Arrays.fill(cnts, Integer.MAX_VALUE);

        cnts[1] = 0;

        for (int i = 1; i <= N; i++) {
            if (cnts[i] == Integer.MAX_VALUE) continue;

            if (i + 1 <= N) {
                cnts[i + 1] = Math.min(cnts[i] + 1, cnts[i + 1]);
            }

            if (i * 2 <= N) {
                cnts[i * 2] = Math.min(cnts[i] + 1, cnts[i * 2]);
            }

            if (i * 3 <= N) {
                cnts[i * 3] = Math.min(cnts[i] + 1, cnts[i * 3]);
            }
        }

        System.out.println(cnts[N]);
    }
}