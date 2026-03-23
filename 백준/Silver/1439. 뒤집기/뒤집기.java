import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        char before = ' ';
        int zeroCnt = 0;
        int oneCnt = 0;

        for (int i = 0; i < str.length(); i++) {
            char curr = str.charAt(i);

            if (before != curr) {
                if (curr == '0') {
                    oneCnt++;
                } else {
                    zeroCnt++;
                }
            }

            before = curr;
        }

        System.out.println(Math.min(zeroCnt, oneCnt));
    }
}