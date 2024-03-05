import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static String S, T;

    private static String reverse(String s) {
        StringBuffer sb = new StringBuffer(s);
        return sb.reverse().toString();
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        S = br.readLine();
        T = br.readLine();

        while (T.length() > S.length()) {
            if (T.charAt(T.length() - 1) == 'A') { // A 제거
                T = T.substring(0, T.length() - 1);
            } else { // B 제거
                T = T.substring(0, T.length() - 1);
                T = reverse(T);
            }
        }

        if (T.equals(S)) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
}