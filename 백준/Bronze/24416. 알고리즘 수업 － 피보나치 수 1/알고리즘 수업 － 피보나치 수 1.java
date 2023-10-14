import java.io.*;

public class Main {
    static int recur; // 재귀 함수 실행 횟수
    static int dp; // 동적 프로그래밍 실행 횟수
    static int[] f;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        f = new int[N + 1];

        fibo(N);
        fibonacci(N);

        System.out.println(recur + " " + dp);
    }
    // 재귀 함수
    static long fibo (int n) {
        if (n == 1 || n == 2) {
            recur++; // 횟수 증가
            return 1;
        }
        else return (fibo(n - 1) + fibo(n - 2));
    }
    // 동적 프로그래밍
    static long fibonacci (int n) {
        f[1] = f[2] = 1;

        for (int i = 3; i <= n; i++) {
            dp++; // 횟수 증가
            f[i] = f[i - 1] + f[i - 2];
        }

        return f[n];
    }
}