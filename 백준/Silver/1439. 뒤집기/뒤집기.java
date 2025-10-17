import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String word = br.readLine();

        int zero = 0;
        int one = 0;
        char before = ' ';
        char c;

        for (int i = 0; i < word.length(); i++) {
            c = word.charAt(i);

            if (before != c) {
                if (c - '0' == 0) zero++;
                else one++;
                before = c;
            }
        }

        System.out.println(Math.min(zero, one));
    }
}