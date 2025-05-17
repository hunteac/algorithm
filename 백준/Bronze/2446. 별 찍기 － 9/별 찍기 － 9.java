import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine()) * 2 - 1;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i < N / 2) {
                    if (j >= i && j < N - i) {
                        sb.append("*");
                    } else if (j < N - i) {
                        sb.append(" ");
                    }
                } else {
                    if (j >= (N - i - 1) && j <= i) {
                        sb.append("*");
                    } else if (j < i) {
                        sb.append(" ");
                    }
                }
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}