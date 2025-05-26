import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        HashMap<Long, Integer> map = new HashMap<>();

        long max = Long.MAX_VALUE;
        int maxCnt = 0;

        for (int i = 0; i < N; i++) {
            long num = Long.parseLong(br.readLine());

            map.put(num, map.getOrDefault(num, 0) + 1);
            int cnt = map.get(num);

            if (cnt > maxCnt) {
                maxCnt = cnt;
                max = num;
            } else if (maxCnt == cnt && num < max) {
                max = num;
            }
        }

        System.out.println(max);
    }
}