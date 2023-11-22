import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            int N = Integer.parseInt(br.readLine());
            if (N == 0) break;
            int sum = 0;
            for (int i = 1; i <= N; i++) {
                sum += i;
            }
            sb.append(sum).append("\n");
        }

        System.out.println(sb);
    }
}