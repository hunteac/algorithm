import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        int len = s.length();

        int[] dp = new int[len];
        dp[0] = 1;

        if (s.charAt(0) == '0') { // 해석 불가능
            System.out.println(0);
            return;
        }

        for (int i = 1; i < len; i++) {
            int curr = s.charAt(i) - '0';
            int before = s.charAt(i - 1) - '0';

            if (before == 1 || before == 2 && curr <= 6) {
                if (i == 1) {
                    if (curr != 0) dp[i] = dp[i - 1] + 1;
                    else dp[i] = dp[i - 1];
                } else {
                    if (curr != 0) dp[i] = (dp[i - 1] + dp[i - 2]) % 1000000;
                    else {
                        dp[i] = dp[i - 2];
                    }
                }
            } else if (curr == 0) { // 해석 불가능
                System.out.println(0);
                return;
            } else {
                dp[i] = dp[i - 1];
            }
        }

        System.out.println(dp[len - 1]);
    }
}