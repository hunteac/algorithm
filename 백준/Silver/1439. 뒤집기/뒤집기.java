import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String word = br.readLine();

        int zeroCnt = 0;
        int oneCnt = 0;

        char before = ' ';

        for (int i = 0; i < word.length(); i++) {
            char curr = word.charAt(i);

            if (curr != before) {
                if (curr == '0') {
                    zeroCnt++;
                } else {
                    oneCnt++;
                }
            }

            before = curr;
        }

        System.out.println(Math.min(zeroCnt, oneCnt));
    }
}