import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 참가자 수
        int A = Integer.parseInt(st.nextToken()); // 김지민 번호
        int B = Integer.parseInt(st.nextToken()); // 임한수 번호
        int round = 1;

        while (true) {
            if (A == 1 && B == 1) { // 서로 만나지 않는 경우
                System.out.println(-1);
                return;
            }
            // 매치 성사
            if ((A + 1 == B) && (A % 2 == 1) || (B + 1 == A) && (B % 2 == 1)) break;
            else { // 다음 라운드 진출
                if (A % 2 == 0) A /= 2;
                else A = (A + 1) / 2;

                if (B % 2 == 0) B /= 2;
                else B = (B + 1) / 2;
            }

            round++; // 라운드 증가
        }

        System.out.println(round);
    }
}