import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String word = br.readLine().toLowerCase();

        int[] cnts = new int[26];
        int max = 0;
        int maxIdx = 0;
        String result = "";

        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            cnts[idx]++;

            if (cnts[idx] > max) {
                max = cnts[idx];
                maxIdx = idx;
                result = word.substring(i, i + 1).toUpperCase();
            }
        }

        for (int i = 0; i < 26; i++) {
            if (i != maxIdx && cnts[i] == max) {
                System.out.println("?");
                return;
            }
        }

        System.out.println(result);
    }
}