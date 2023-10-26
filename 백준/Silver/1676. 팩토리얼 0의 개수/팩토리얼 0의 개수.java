import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        BigInteger num = new BigInteger("1");

        for (int i = 1; i <= N; i++) {
            String s = String.valueOf(i);
            BigInteger bs = new BigInteger(s);

            num = num.multiply(bs);
        }

        String snum = String.valueOf(num);
        int cnt = 0;

        // 뒤에서부터 0이 아닌 숫자가 나올 때까지 0의 개수 구하기
        for (int i = snum.length() - 1; i >= 0; i--) {
            if (snum.charAt(i) - '0' != 0) break;
            cnt++;
        }

        System.out.println(cnt);
    }
}