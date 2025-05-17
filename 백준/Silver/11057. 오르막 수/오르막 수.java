import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int cnt = 0;

        int[][] cntArr = new int[N + 1][10];

        for (int i = 0; i < 10; i++) {
            cntArr[1][i] = 1;
        }

        for (int i = 2; i <= N; i++) {
            for (int j = 0; j < cntArr[0].length; j++) {
                if (j - 1 >= 0) cntArr[i][j] = (cntArr[i - 1][j] + cntArr[i][j - 1]) % 10007;
                else cntArr[i][j] = (cntArr[i - 1][j] + cntArr[i][j]) % 10007;
            }
        }

        for (int i = 0; i < 10; i++) {
            cnt = (cnt + cntArr[N][i]) % 10007;
        }

        System.out.println(cnt);
    }
}