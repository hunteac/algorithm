import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine()) * 2;

        for (int i = 0; i < N - 1; i++) {
            for (int j = 0; j < N; j++) {
                if (i < N / 2) {
                    if (j <= i || j >= (N - i - 1)) {
                        sb.append("*");
                    } else {
                        sb.append(" ");
                    }
                } else {
                    if (j > i || j < (N - i - 1)) {
                        sb.append("*");
                    } else {
                        sb.append(" ");
                    }
                }
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}