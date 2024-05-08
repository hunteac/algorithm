import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int cnt = 1;

        while (true) {
            int N = Integer.parseInt(br.readLine()); // 여학생 수

            if (N == 0) break; // 종료

            String[] students = new String[N];
            int[] chk = new int[N]; // 돌려받았는지 체크

            for (int i = 0; i < N; i++) {
                String name = br.readLine(); // 학생 이름

                students[i] = name;
            }

            for (int i = 0; i < 2 * N - 1; i++) {
                st = new StringTokenizer(br.readLine());

                int num = Integer.parseInt(st.nextToken()) - 1; // 여학생 번호

                chk[num]++;
            }

            for (int i = 0; i < N; i++) {
                // chk == 2일 때 귀걸이를 돌려받는다.
                if (chk[i] < 2) sb.append(cnt).append(" ").append(students[i]).append("\n");
            }

            cnt++;
        }

        System.out.println(sb);
    }
}
