import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Order {
        String num;
        String str;

        Order (String num, String str) {
            this.num = num;
            this.str = str;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            boolean[] chk = new boolean[10000]; // 중복 체크
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            Queue<Order> queue = new LinkedList<>();

            queue.add(new Order(String.valueOf(A), ""));
            String answer = "";

            while (!queue.isEmpty()) {
                Order order = queue.poll();

                String num = order.num;
                String str = order.str;
                int n = Integer.parseInt(num);

                StringBuilder nextStr = new StringBuilder();

                nextStr.append("0".repeat(Math.max(0, 4 - num.length())));
                nextStr.append(num);

                if (Integer.parseInt(num) == B) { // 완성
                    answer = str;
                    break;
                }

                int next = n * 2 % 10000;
                if (!chk[next]) {
                    queue.add(new Order(String.valueOf(next), str + "D")); // D
                    chk[next] = true;
                }

                next = n == 0 ? 9999 : n - 1;
                if (!chk[next]) {
                    queue.add(new Order(String.valueOf(next), str + "S")); // S
                    chk[next] = true;
                }

                next = Integer.parseInt(nextStr.substring(1) + nextStr.charAt(0));
                if (!chk[next] && (!str.endsWith("LLL") || str.charAt(str.length() - 1) != 'R')) {
                    queue.add(new Order(String.valueOf(next), str + "L")); // L
                    chk[next] = true;
                }

                next = Integer.parseInt(nextStr.charAt(3) + nextStr.substring(0, 3));
                if (!chk[next] && (!str.endsWith("RRR") || str.charAt(str.length() - 1) != 'L')) {
                    queue.add(new Order(String.valueOf(next), str + "R")); // R
                    chk[next] = true;
                }
            }

            sb.append(answer).append("\n");
        }

        System.out.println(sb);
    }
}