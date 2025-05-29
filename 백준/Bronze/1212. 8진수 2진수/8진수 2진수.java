import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String octal = br.readLine();

        for (int i = 0; i < octal.length(); i++) {
            int digit = octal.charAt(i) - '0';
            String binary = Integer.toBinaryString(digit);

            if (i == 0) {
                sb.append(binary);
            } else {
                while (binary.length() < 3) {
                    binary = "0" + binary;
                }
                sb.append(binary);
            }
        }

        System.out.println(sb);
    }
}