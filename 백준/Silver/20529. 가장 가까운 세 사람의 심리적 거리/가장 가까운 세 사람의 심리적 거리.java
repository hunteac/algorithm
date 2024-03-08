import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static String[] MBTIs;
    static int res = Integer.MAX_VALUE;

    static int calcMBTIdist(int i, int j, int k) {
        int cnt = 0;

        for (int idx = 0; idx < 4; idx++) {
            cnt += MBTIs[i].charAt(idx) != MBTIs[j].charAt(idx) ? 1 : 0;
            cnt += MBTIs[j].charAt(idx) != MBTIs[k].charAt(idx) ? 1 : 0;
            cnt += MBTIs[k].charAt(idx) != MBTIs[i].charAt(idx) ? 1 : 0;
        }

        return cnt;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine());

            MBTIs = new String[n];
            res = Integer.MAX_VALUE;

            StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());

            if (n > 32) { // mbti가 동일한 세 명 존재
                sb.append(0).append("\n");
                continue;
            }

            for (int i = 0; i < n; i++) {
                MBTIs[i] = stringTokenizer.nextToken();
            }

            for (int i = 0; i < n - 2; i++) {
                if (res == 0) break;
                for (int j = i + 1; j < n - 1; j++) {
                    if (res == 0) break;
                    for (int k = j + 1; k < n; k++) {
                        res = Math.min(res, calcMBTIdist(i, j, k));
                        if (res == 0) break;
                    }
                }
            }

            sb.append(res).append("\n");
        }

        System.out.println(sb);
    }
}