import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); // 강 서쪽 다리 수
            int M = Integer.parseInt(st.nextToken()); // 강 동쪽 다리 수
            long answer = 0;
            long tmpM = 1;
            for (int i = 1; i <= N; i++) { // 조합 계산
                tmpM *= M--;
                answer = tmpM / i;
                tmpM /= i;
            }
            sb.append(answer).append("\n");
        }
        System.out.println(sb);
    }
}