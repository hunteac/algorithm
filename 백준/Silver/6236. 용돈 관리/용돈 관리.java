import java.io.*;
import java.util.*;

public class Main {
    static int[] charges;
    static int getMid (int tmp) {
        int cnt = 1;
        int money = tmp;

        for (int num : charges) {
            money -= num;

            if (money < 0) {
                cnt++;
                money = tmp - num;
            }
        }

        return cnt;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        charges = new int[N];

        int start = 0;
        int end = 0;

        for (int i = 0; i < N; i++) {
            charges[i] = Integer.parseInt(br.readLine());
            start = Math.max(start, charges[i]);
            end += charges[i];
        }

        int result = 0;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (M >= getMid(mid)) {
                result = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        System.out.println(result);
    }
}
