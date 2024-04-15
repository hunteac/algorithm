import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Order {
        int num;
        String command;

        Order (int num, String command) {
            this.num = num;
            this.command = command;
        }

        int D () {
            return (num * 2) % 10000;
        }

        int S () {
            return num == 0 ? 9999 : num - 1;
        }

        int L () {
            return (num * 10) % 10000 + (num / 1000);
        }

        int R () {
            return (num % 10 * 1000) + (num / 10);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());

            boolean[] chk = new boolean[10000];
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            Queue<Order> queue = new LinkedList<>();

            queue.add(new Order(A, ""));
            String answer = "";

            while (!queue.isEmpty()) {
                Order order = queue.poll();

                int num = order.num;
                String command = order.command;

                if (num == B) { // 완성
                    sb.append(command).append("\n");
                    break;
                }

                if (!chk[order.D()]) { // D
                    queue.add(new Order(order.D(), command + "D")); // D
                    chk[order.D()] = true;
                }

                if (!chk[order.S()]) { // S
                    queue.add(new Order(order.S(), command + "S")); // S
                    chk[order.S()] = true;
                }

                if (!chk[order.L()]) { // L
                    queue.add(new Order(order.L(), command + "L")); // L
                    chk[order.L()] = true;
                }

                if (!chk[order.R()]) { // R
                    queue.add(new Order(order.R(), command + "R")); // R
                    chk[order.R()] = true;
                }
            }
        }

        System.out.println(sb);
    }
}