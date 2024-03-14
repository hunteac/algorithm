import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            int cnt = 1; // 순서
            int currX = 1; // 현재 년도 X
            int currY = 1; // 현재 년도 Y
            boolean chk = false;

            while (true) {
                if (x - currX == y - currY) { // 순서 완성
                    cnt += x - currX;
                    chk = true;
                    break;
                }

                if (M - currX < N - currY) {
                    cnt += M - currX + 1;
                    currY += M - currX + 1;
                    currX = 1;
                } else if (M - currX > N - currY) {
                    cnt += N - currY + 1;
                    currX += N - currY + 1;
                    currY = 1;
                } else {
                    cnt += N - currY + 1;
                    currX = currY = 1;
                }

                if (currX == 1 && currY == 1) break; // 완성 불가능
            }

            if (chk) sb.append(cnt).append("\n");
            else sb.append(-1).append("\n");
        }

        System.out.println(sb);
    }
}
