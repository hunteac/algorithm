import java.util.Scanner;

public class Solution {
    static long[] memo;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 5; i++) {
            int n = sc.nextInt();
            memo = new long[n + 1];
            memo[1] = 1;

            System.out.println(fibo(n));
        }
    }
    // 피보나치 수열
    static long fibo(int n) {
        if (n >= 2 && memo[n] == 0) {
            memo[n] = fibo(n - 1) + fibo(n - 2);
        }
        return memo[n];
    }
}