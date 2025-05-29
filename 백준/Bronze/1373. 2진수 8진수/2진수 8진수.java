import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String binary = br.readLine();
        int num = 0;

        for (int i = binary.length() - 1; i >= 0; i -= 3) {
            num += binary.charAt(i) == '1' ? 1 : 0;
            if (i - 1 >= 0) num += binary.charAt(i - 1) == '1' ? 2 : 0;
            if (i - 2 >= 0) num += binary.charAt(i - 2) == '1' ? 4 : 0;

            sb.append(num);
            num = 0;
        }

        System.out.println(sb.reverse());
    }
}