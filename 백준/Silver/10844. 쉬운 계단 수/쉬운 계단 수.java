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
            if (i == 0) cntArr[1][i] = 0;
            else cntArr[1][i] = 1;
        }

        for (int i = 2; i <= N; i++) {
            for (int j = 0; j < cntArr[0].length; j++) {
                if (j - 1 >= 0) {
                    cntArr[i][j] = (cntArr[i][j] + cntArr[i - 1][j - 1]) % 1000000000;
                }

                if (j + 1 <= 9) {
                    cntArr[i][j] = (cntArr[i][j] + cntArr[i - 1][j + 1]) % 1000000000;
                }
            }
        }

        for (int i = 0; i < 10; i++) {
            cnt = (cnt + cntArr[N][i]) % 1000000000;
        }

        System.out.println(cnt);
    }
}