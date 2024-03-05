import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    static boolean chk;
    static int aCnt;
    static int bCnt;

    static void dfs(String S, String T, String curr, int a, int b) {
        if (T.equals(curr)) {
            chk = true;
            return;
        } else if (curr.length() == T.length() || a > aCnt || b > bCnt || chk) {
            return;
        }

        StringBuffer sb = new StringBuffer(curr);
        String reverse = sb.reverse().toString();

        if (!T.contains(curr) && !T.contains(reverse)) return;

        dfs(S, T, curr + "A", a + 1, b); // A 추가
        dfs(S, T, reverse + "B", a, b + 1); // 뒤집고 B 추가
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String S = br.readLine();
        String T = br.readLine();

        int a = 0;
        int b = 0;

        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == 'A') a++;
            else b++;
        }

        for (int i = 0; i < T.length(); i++) {
            if (T.charAt(i) == 'A') aCnt++;
            else bCnt++;
        }

        dfs(S, T, S, a, b);

        if (chk) System.out.println(1);
        else System.out.println(0);
    }
}