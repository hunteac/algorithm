import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String ipv6 = br.readLine();
        boolean chk = false;
        int cnt = 0; // 콜론 간격의 문자 수

        for (int i = 0; i < ipv6.length(); i++) {
            if (ipv6.charAt(i) == ':') chk = false;
            else {
                if (!chk) cnt++;
                chk = true;
            }
        }

        String num = "";
        int numCnt = 0;

        for (int i = 0; i < ipv6.length(); i++) {
            if (ipv6.charAt(i) == ':' || i == ipv6.length() - 1) { // 콜론 2개 OR 마지막 문자
                if (i < ipv6.length() - 1 && ipv6.charAt(i + 1) == ':') { // 축약된 만큼 0000 더하기
                    if (!num.isEmpty()) {
                        for (int j = 0; j < 4 - num.length(); j++) sb.append(0); // 생략된 0 채우기
                        sb.append(num).append(":");
                        numCnt++;
                    }

                    for (int j = 0; j < 8 - cnt; j++) {
                        numCnt++;
                        if (numCnt < 8) sb.append("0000").append(":");
                        else sb.append("0000");
                    }
                    i++;
                    num = ""; // 초기화
                    continue;
                }

                if (i == ipv6.length() - 1) num += ipv6.charAt(i); // 마지막 문자 더하기

                for (int j = 0; j < 4 - num.length(); j++) sb.append(0); // 생략된 0 채우기

                if (i != ipv6.length() - 1) sb.append(num).append(":");
                else sb.append(num);

                numCnt++;
                num = ""; // 초기화
            } else {
                num += ipv6.charAt(i);
            }
        }

        System.out.println(sb);
    }
}
