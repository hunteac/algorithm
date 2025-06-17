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

        boolean chk = false;
        int cnt = 1;
        int last = 0;

        while (A <= B) {
            if (A == B) {
                chk = true;
                break;
            }

            String sB = String.valueOf(B);
            last = sB.length() - 1;

            if (B % 2 == 0) {
                B /= 2;
            } else if (sB.charAt(last) - '0' == 1) {
                B = Integer.parseInt(sB.substring(0, last));
            } else {
                break;
            }

            cnt++;
        }

        if (chk) System.out.println(cnt);
        else System.out.println(-1);
    }
}