import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        while (N > 0) {
            String num = String.valueOf(N);
            boolean chk = true;

            for (int i = 0; i < num.length(); i++) {
                if (num.charAt(i) - '0' != 7 && num.charAt(i) - '0' != 4) chk = false;
            }

            if (chk) {
                System.out.println(num);
                return;
            }

            N--;
        }
    }
}
