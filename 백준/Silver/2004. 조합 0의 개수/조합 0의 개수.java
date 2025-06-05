import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        long cnt;
        long totalTwos;
        long totalFives;

        totalTwos = countPrime(n, 2) - countPrime(m, 2) - countPrime(n - m, 2);
        totalFives = countPrime(n, 5) - countPrime(m, 5) - countPrime(n - m, 5);

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