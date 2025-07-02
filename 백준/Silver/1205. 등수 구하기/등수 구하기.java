import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        if (N == 0) {
            System.out.println(1);
            return;
        }

        int[] scores = new int[N];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) scores[i] = Integer.parseInt(st.nextToken());

        int rank = 1;
        int same = 0;

        for (int i = 0; i < N; i++) {
            int score = scores[i];

            if (scores[i] > S) rank++;
            else if (scores[i] == S) same++;
            else if (score < S) break;
        }

        if (rank + same <= P) System.out.println(rank);
        else System.out.println(-1);
    }
}