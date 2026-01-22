import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            String pwd = br.readLine();

            if ("end".equals(pwd)) {
                System.out.println(sb);
                break;
            }

            boolean pwdChk = true; // 패스워드 사용 가능 여부
            boolean vChk = false; // 모음 여부
            int vCnt = 0; // 연속된 모음 개수
            int cCnt = 0; // 연속된 자음 개수
            char before = ' ';

            for (int i = 0; i < pwd.length(); i++) {
                char c = pwd.charAt(i);

                if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') { // 모음
                    if (vCnt == 2 || (c == before && c != 'e' && c != 'o')) {
                        pwdChk = false;
                        break;
                    } else {
                        vCnt++;
                        cCnt = 0;
                        before = c;
                        vChk = true;
                    }
                } else { // 자음
                    if (cCnt == 2 || c == before) {
                        pwdChk = false;
                        break;
                    } else {
                        cCnt++;
                        before = c;
                        vCnt = 0;
                    }
                }
            }

            if (pwdChk && vChk) {
                sb.append("<").append(pwd).append(">").append(" is acceptable.");
            } else {
                sb.append("<").append(pwd).append(">").append(" is not acceptable.");
            }
            sb.append("\n");
        }
    }
}