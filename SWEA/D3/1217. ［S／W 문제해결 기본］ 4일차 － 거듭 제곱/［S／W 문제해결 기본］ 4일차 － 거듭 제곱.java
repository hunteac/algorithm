import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int tc = 1; tc <= 10; tc++) {
            int num = sc.nextInt();
            int N = sc.nextInt();
            int M = sc.nextInt();
            System.out.println("#" + tc + " " + pow(N, M));
        }
    }
    // 재귀를 이용한 거듭제곱 메소드
    public static int pow(int N, int M) {
        int tmp = 0;
        // 기저파트
        if (M == 1) return N;
        // 재귀파트
        if (M % 2 == 0) { // N이 짝수일 때
            tmp = pow(N, M / 2);
            return tmp * tmp;
        } else { // M이 홀수일 때
            tmp = pow(N, M / 2);
            return tmp * tmp * N;
        }
    }
}