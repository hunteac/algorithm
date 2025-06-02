import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int num = Integer.parseInt(br.readLine());

        while (num != 0) {
            if (num > 0) {
                sb.append(num % -2);
                num /= -2;
            } else {
                sb.append(Math.abs(num % -2));
                num += num % -2;
                num /= -2;
            }
        }

        if (sb.length() == 0) sb.append("0");

        System.out.println(sb.reverse());
    }
}