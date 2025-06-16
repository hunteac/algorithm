import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        BigInteger cnt = new BigInteger("1");
        BigInteger mul = new BigInteger("2");
        BigInteger num = new BigInteger("1");

        for (int i = 2; i <= N; i++) {
            cnt = cnt.multiply(mul).add(num);
        }

        sb.append(cnt).append("\n");

        if (N <= 20) hanoi(sb, N, 1, 2, 3);

        System.out.println(sb);
    }

    public static void hanoi(StringBuilder sb, int num, int start, int aux, int end) {
        if (num == 1) {
            sb.append(start).append(" ").append(end).append("\n");
        } else {
            hanoi(sb, num - 1, start, end, aux);
            sb.append(start).append(" ").append(end).append("\n");
            hanoi(sb, num - 1, aux, start, end);
        }
    }
}