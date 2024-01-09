import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int X = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        for (int i = N; i > 0; i--) {
            if (X % 2 == 0) X = (X / 2) ^ 6;
            else X = (2 * X) ^ 6;
        }

        System.out.println(X);
    }
}