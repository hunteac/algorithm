import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] hamburger = new int[3];
        int[] drink = new int[2];

        for (int i = 0; i < 3; i++) hamburger[i] = Integer.parseInt(br.readLine());
        for (int i = 0; i < 2; i++) drink[i] = Integer.parseInt(br.readLine());

        int min = Integer.MAX_VALUE;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 2; j++) {
                min = Math.min(min, hamburger[i] + drink[j] - 50);
            }
        }

        System.out.println(min);
    }
}