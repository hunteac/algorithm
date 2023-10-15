import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        if (n == 1) {
            System.out.println(1);
            return;
        }

        int[] f = new int[n + 1];

        f[1] = 1;
        f[2] = 2;

        // 동적계획법
        for (int i = 3; i <= n; i++) {
            f[i] = (f[i - 1] + f[i - 2]) % 15746;
        }

        System.out.println(f[n]);
    }
}