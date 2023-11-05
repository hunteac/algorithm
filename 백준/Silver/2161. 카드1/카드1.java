import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            queue.add(i);
        }

        int cnt = 1;

        while (!queue.isEmpty()) {
            if (cnt % 2 == 1) {
                sb.append(queue.poll()).append(" ");
            } else {
                int curr = queue.poll();
                queue.add(curr);
            }
            cnt++;
        }

        System.out.println(sb);
    }
}