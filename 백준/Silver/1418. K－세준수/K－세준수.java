import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int K;

    static boolean check(int n) {
        boolean result = false;
        int num = n;

        for (int i = 2; ; i++) {
            if (num % i == 0 && i <= K) {
                num /= i; // 소인수 분해
                i = 1;
            }

            if (num == 1) { // 조건 충족
                result = true;
                break;
            } else if (i > K) { // 최대 소인수 > K
                break;
            }
        }

        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());

        int cnt = 1; // K-세준수

        for (int i = 2; i <= N; i++) {
            if (check(i)) cnt++;
        }

        System.out.println(cnt);
    }
}
