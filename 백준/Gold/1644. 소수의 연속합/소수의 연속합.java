import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    static ArrayList<Integer> prime; // 소수 리스트
    static boolean[] isPrime; // 소수 판별
    
    // 에라토스테네스의 체 소수 판별
    static void getPrime(int N) {
        for (int i = 2; i <= Math.sqrt(N); i++) {
            if (isPrime[i]) { // 해당수가 소수이면 배수 false 처리
                for (int j = i * i; j <= N; j += i) {
                    isPrime[j] = false;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        prime = new ArrayList<>();
        isPrime = new boolean[N + 1];

        Arrays.fill(isPrime, true);

        isPrime[0] = isPrime[1] = false; // 0과 1은 소수가 아니다.

        getPrime(N);

        int before = 2; // 전 소수
        prime.add(2);

        for (int i = 3; i <= N; i++) {
            if (before + i > N) break;
            if (isPrime[i]) {
                prime.add(i);
                before = i;
            }
        }

        int cnt = 0; // 경우의 수

        for (int i = 0; i < prime.size() - 1; i++) {
            int sum = prime.get(i); // 연속합
            for (int j = i + 1; j < prime.size(); j++) {
                sum += prime.get(j);

                if (sum > N) break; // 불가능
                else if (sum == N) { // 연속합 가능
                    cnt++;
                    break;
                }
            }
        }

        if (isPrime[N]) cnt++; // 소수면 자신 포함

        System.out.println(cnt);
    }
}