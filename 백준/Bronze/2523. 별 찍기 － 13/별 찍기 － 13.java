import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        for (int i = 1; i <= 2 * N - 1; i++) {
            String str = "";
            if (i <= N) {
                for (int j = 1; j <= i; j++) {
                    str += '*';
                }
                sb.append(str).append("\n");
            } else {
                for (int j = 1; j <= 2 * N - i; j++) {
                    str += '*';
                }
                sb.append(str).append("\n");
            }
        }

        System.out.println(sb);
    }
}
