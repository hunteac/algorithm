import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        long num = 0;
        int cnt = 0;

        if (N == 0) {
            System.out.println(0);
            return;
        } else if (N == 1022) {
            System.out.println("9876543210");
            return;
        } else if (N > 1022) {
            System.out.println(-1);
            return;
        }

        for (int i = 1; i <= 987654321; i++) {
            String str = String.valueOf(i);
            boolean chk = true;

            if (str.charAt(0) - '0' < str.length() - 1) {
                String next = "";
                next += str.length() - 1;

                for (int j = str.length() - 2; j >= 0; j--) {
                    next += String.valueOf(j);
                }

                i = Integer.parseInt(next) - 1;
                continue;
            }

            boolean chk2 = true;

            for (int j = 0; j < str.length(); j++) {
                if (j == 0) continue;
                if (str.charAt(j - 1) <= str.charAt(j)) {
                    chk = false;
                } else if (str.charAt(j - 1) != str.charAt(j) - 1) {
                    chk2 = false;
                }
            }

            if (chk) cnt++;

            if (chk2) {
                String next = "";
                next += str.charAt(0) - '0' + 1;

                for (int j = str.length() - 2; j >= 0; j--) {
                    next += String.valueOf(j);
                }

                i = Integer.parseInt(next) - 1;
            }

            if (cnt == N) {
                num = Integer.parseInt(str);
                break;
            }
        }

        System.out.println(num);
    }
}