import java.util.*;

public class Main {
    static long[] P; // 파도반 수열

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        P = new long[101];

        P[1] = P[2] = P[3] = 1;
        P[4] = P[5] = 2;
        P[6] = 3;
        P[7] = 4;
        P[8] = 5;

        for (int tc = 1; tc <= T; tc++) {
            int N = sc.nextInt();

            if (P[N] != 0) {
                System.out.println(P[N]);
                continue;
            }

            for (int i = 9; i <= N; i++) {
                P[i] = P[i - 5] + P[i - 1];
            }

            System.out.println(P[N]);
        }
    }
}