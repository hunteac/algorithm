import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str1 = br.readLine();
        String str2 = "MOBIS";

        int[] alphabets = new int[26];

        for (int i = 0; i < str1.length(); i++) {
            alphabets[str1.charAt(i) - 65]++;
        }

        for (int i = 0; i < str2.length(); i++) {
            if (alphabets[str2.charAt(i) - 65] == 0) {
                System.out.println("NO");
                return;
            }
        }

        System.out.println("YES");
    }
}
