import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        long cnt;
        long totalTwos;
        long totalFives;

        totalTwos = countPrime(n, 2);
        totalFives = countPrime(n, 5);

        cnt = Math.min(totalTwos, totalFives);

        System.out.println(cnt);
    }

    public static long countPrime(long n, int p) {
        long cnt = 0;

        for (long i = p; i <= n; i *= p) {
            cnt += n / i;
        }

        return cnt;
    }
}