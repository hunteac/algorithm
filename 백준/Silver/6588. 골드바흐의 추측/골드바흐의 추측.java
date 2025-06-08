import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        boolean[] primeChk = new boolean[1000000];

        getPrime(primeChk);

        while (true) {
            int n = Integer.parseInt(br.readLine());

            if (n == 0) break;

            boolean chk = false;

            int prime = 0;

            for (int i = 3; i < primeChk.length; i++) {
                if (primeChk[i]) continue;

                prime = i;
                
                if (!primeChk[n - prime]) {
                    chk = true;
                    break;
                }
            }

            if (chk) sb.append(n).append(" = ").append(prime).append(" + ").append(n - prime).append("\n");
            else sb.append("Goldbach's conjecture is wrong.").append("\n");
        }

        System.out.println(sb);
    }

    public static void getPrime(boolean[] primeChk) {
        int n = primeChk.length;

        for (int i = 2; i * i < n; i++) {
            if (primeChk[i]) continue;
            for (int j = i * i; j < n; j += i) {
                primeChk[j] = true;
            }
        }
    }
}