import java.util.*;

public class Main {
    static int dp; // 동적 프로그래밍 실행 횟수
    static int[] f;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        f = new int[N + 1];

        fibonacci(N);

        System.out.println(fibo(N) + " " + dp);
    }
    // 재귀 함수
    static long fibo (int n) {
        if (n == 1 || n == 2) return 1;
        else return (fibo(n - 1) + fibo(n - 2));
    }
    // 동적 프로그래밍
    static long fibonacci (int n) {
        f[1] = f[2] = 1;

        for (int i = 3; i <= n; i++) {
            dp++;
            f[i] = f[i - 1] + f[i - 2];
        }

        return f[n];
    }
}