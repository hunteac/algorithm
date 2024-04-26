import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static HashSet<Character> vowelSet = new HashSet<>();
    static char[] chars;
    static int L, C;

    static void getPwd(int curr, String pwd, int vCnt, int cCnt) {
        if (pwd.length() == L) { // 암호 완성
            if (vCnt >= 1 && cCnt >= 2) sb.append(pwd).append("\n"); // 사용 가능
            return;
        }
        if (curr >= C) return; // 범위 초과

        for (int idx = curr; idx < C; idx++) {
            if (vowelSet.contains(chars[idx])) getPwd(idx + 1, pwd + chars[idx], vCnt + 1, cCnt); // 모음
            else getPwd(idx + 1, pwd + chars[idx], vCnt, cCnt + 1); // 자음
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        chars = new char[C];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < C; i++) chars[i] = st.nextToken().charAt(0);

        Arrays.sort(chars); // 오름차순 정렬

        vowelSet.add('a');
        vowelSet.add('e');
        vowelSet.add('i');
        vowelSet.add('o');
        vowelSet.add('u');

        getPwd(0, "", 0, 0);

        System.out.println(sb);
    }
}
