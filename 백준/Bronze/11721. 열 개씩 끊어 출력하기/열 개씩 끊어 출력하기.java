import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String str = br.readLine();
        int len = str.length() / 10;

        for (int i = 0; i <= len; i++) {
            if (i < len) {
                sb.append(str.substring(10 * i, 10 * (i + 1)));
            } else {
                sb.append(str.substring(10 * i));
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}