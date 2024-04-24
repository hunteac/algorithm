import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());

        boolean[] checkPrime = new boolean[100001]; // 소수 판별
        Arrays.fill(checkPrime, true);
        checkPrime[0] = checkPrime[1] = false;

        // 에라토스테네스의 체
        for (int i = 2; i <= Math.sqrt(100000); i++) {
            if (!checkPrime[i]) continue;

            for (int j = i * i; j <= 100000; j += i) checkPrime[j] = false;
        }

        ArrayList<Integer> prime = new ArrayList<>();

        for (int i = 2; i <= 100000; i++) if (checkPrime[i]) prime.add(i);

        int cnt = 1; // K-세준수

        for (int i = 1; i <= N; i++) {
            int num = i;
            int idx = 0;
            int max = 0; // 소인수 최댓값
            int curr = prime.get(idx++); // 현재 소인수

            while (curr <= num && idx < prime.size()) {
                if (num % curr == 0) {
                    num /= curr; // 소인수 분해
                    max = curr; // 최댓값 갱신
                }
                curr = prime.get(idx++); // 다음 소수
            }

            if (max != 0 && max <= K) cnt++; // 소인수 중 최댓값이 K보다 크지 않은 경우
        }

        System.out.println(cnt);
    }
}
