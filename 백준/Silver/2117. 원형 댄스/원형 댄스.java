import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        if (N <= 3) {
            System.out.println(N <= 2 ? 0 : 1);
        } else {
            int min = 0;

            for (int i = 0; i <= N / 2 - 1; i++) { // 첫번째 집합
                min += i;
            }

            for (int i = 0; i <= N - (N / 2) - 1; i++) { // 두번째 집합
                min += i;
            }

            System.out.println(min);
        }
    }
}