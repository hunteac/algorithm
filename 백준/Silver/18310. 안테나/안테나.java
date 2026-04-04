import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());

        int[] places = new int[N];

        for (int i = 0; i < N; i++) {
            places[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(places);

        int mid = N / 2;

        if (N % 2 == 0) {
            int sum1 = 0;
            int sum2 = 0;

            for (int i = 0; i < N; i++) {
                int place = places[i];
                if (place != places[mid]) {
                    sum1 += Math.abs(places[mid] - place);
                }
                if (place != places[mid - 1]) {
                    sum2 += Math.abs(places[mid - 1] - place);
                }
            }

            if (sum2 >= sum1) mid--;
        }

        System.out.println(places[mid]);
    }
}