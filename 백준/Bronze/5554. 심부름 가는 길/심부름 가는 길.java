import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int dist = 0;

        for (int i = 0; i < 4; i++) {
            int next = Integer.parseInt(br.readLine());
            dist += next;
        }

        System.out.println(dist / 60);
        System.out.println(dist % 60);
    }
}