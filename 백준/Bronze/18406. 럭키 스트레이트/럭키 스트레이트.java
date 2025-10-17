import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String N = br.readLine();

        int left = 0;
        int right = 0;

        for (int i = 0; i < N.length(); i++) {
            int num = N.charAt(i) - '0';

            if (i < N.length() / 2) left += num;
            else right += num;
        }

        if (left == right) System.out.println("LUCKY");
        else System.out.println("READY");
    }
}