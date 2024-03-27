import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String str = br.readLine();

        int idx = 0;
        int cnt = 0;

        while (idx < str.length()) {
            if (str.charAt(idx) == 'X' && idx < str.length() - 1) {
                cnt++;
            } else {
                if (str.charAt(idx) == 'X' && idx == str.length() - 1) cnt++;

                if (cnt % 2 == 1) {
                    System.out.println(-1);
                    return;
                } else if (cnt >= 2) {
                    while (cnt > 0) {
                        if (cnt >= 4) {
                            sb.append("AAAA");
                            cnt -= 4;
                        } else if (cnt >= 2) {
                            sb.append("BB");
                            cnt -= 2;
                        }
                    }
                }

                if (str.charAt(idx) == '.') sb.append(".");
            }

            idx++;
        }

        System.out.println(sb);
    }
}
