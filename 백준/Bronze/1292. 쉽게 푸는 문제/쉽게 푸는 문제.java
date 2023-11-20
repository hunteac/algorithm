import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int[] arr = new int[B];

        int num = 0;
        int next = 1;

        for (int i = 0; i < B; i++) {
            arr[i] = next;

            num++;

            if (num == next) {
                num = 0;
                next++;
            }
        }

        int sum = 0;

        for (int i = A - 1; i <= B - 1; i++) {
            sum += arr[i];
        }

        System.out.println(sum);
    }
}