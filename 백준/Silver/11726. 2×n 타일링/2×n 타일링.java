import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        if (N == 1) {
            System.out.println(1);
            return;
        }

        int[] cnt = new int[N + 1];
        cnt[1] = 1;
        cnt[2] = 2;

        if (N == 2) {
            System.out.println(2);
            return;
        }

        for (int i = 3; i <= N; i++) {
            cnt[i] = (cnt[i - 1] + cnt[i - 2]) % 10007;
        }

        System.out.println(cnt[N]);
    }
}