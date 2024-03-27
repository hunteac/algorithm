import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        boolean zeroChk = false;
        boolean oneChk = false;
        int zeroCnt = 0;
        int oneCnt = 0;

        for (int i = 0; i < str.length(); i++) {
            char num = str.charAt(i);

            if (num == '0') {
                if (!zeroChk) zeroCnt++;
                zeroChk = true;
                oneChk = false;
            } else {
                if (!oneChk) oneCnt++;
                oneChk = true;
                zeroChk = false;
            }
        }

        System.out.println(Math.min(zeroCnt, oneCnt));
    }
}
