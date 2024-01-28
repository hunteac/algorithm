import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] scores = new int[3];

        for (int i = 0; i < 3; i++) scores[i] = Integer.parseInt(st.nextToken());

        int sum = 0;
        int min = Integer.MAX_VALUE;
        int minIdx = 0;

        for (int i = 0; i < 3; i++) {
            sum += scores[i];
            if (min > scores[i]) {
                min = scores[i];
                minIdx = i;
            }
        }

        if (sum >= 100) System.out.println("OK");
        else {
            if (minIdx == 0) System.out.println("Soongsil");
            else if (minIdx == 1) System.out.println("Korea");
            else System.out.println("Hanyang");
        }
    }
}