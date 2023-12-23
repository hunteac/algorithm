import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = 0;
        int S = 0;

        for (int i = 0; i < 2; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 4; j++) {
                if (i == 0) T += Integer.parseInt(st.nextToken());
                if (i == 1) S += Integer.parseInt(st.nextToken());

            }
        }

        System.out.println(Math.max(T, S));
    }
}