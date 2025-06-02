import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());

        int num = 0;

        for (int i = m - 1; i >= 0; i--) {
            int n = Integer.parseInt(st.nextToken());
            num += (int) Math.pow(A, i) * n;
        }

        while (num != 0) {
            sb.insert(0, num % B);
            num /= B;
            if (num != 0) sb.insert(0, " ");
        }

        System.out.println(sb);
    }
}