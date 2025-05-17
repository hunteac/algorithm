import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        long cnt = 0;

        long[][] cntArr = new long[N + 1][2];

        cntArr[1][1] = 1;

        for (int i = 2; i <= N; i++) {
            cntArr[i][0] = cntArr[i - 1][0] + cntArr[i - 1][1];
            cntArr[i][1] = cntArr[i - 1][0];
        }

        cnt = cntArr[N][0] + cntArr[N][1];

        System.out.println(cnt);
    }
}