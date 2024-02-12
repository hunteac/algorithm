import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int score = 0;
        int sum = 0;

        for (int i = 0; i < N; i++) {
            if (st.nextToken().equals("0")) {
                score = 0;
            } else {
                score++;
                sum += score;
            }
        }

        System.out.println(sum);
    }
}
