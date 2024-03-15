import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            int k = Integer.parseInt(br.readLine()); // 연산 개수

            TreeMap<Integer, Integer> map = new TreeMap<>(); // 트리맵 활용

            for (int i = 0; i < k; i++) {
                String order = br.readLine();
                String str = order.substring(0, 1);
                int num = Integer.parseInt(order.substring(2));

                if (str.equals("I")) {
                    map.put(num, map.getOrDefault(num, 0) + 1);
                } else {
                    if (map.isEmpty()) continue;

                    int target = 0;

                    if (num == 1) target = map.lastKey(); // 최댓값
                    else target = map.firstKey(); // 최솟값

                    if (map.put(target, map.get(target) - 1) == 1) map.remove(target); // 제거
                }
            }

            if (map.isEmpty()) sb.append("EMPTY").append("\n");
            else sb.append(map.lastKey()).append(" ").append(map.firstKey()).append("\n");
        }

        System.out.println(sb);
    }
}