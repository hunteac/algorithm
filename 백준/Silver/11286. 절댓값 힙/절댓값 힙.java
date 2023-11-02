import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 절댓값을 기준으로 정렬하는 우선순위 큐
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (Math.abs(o1) == Math.abs(o2)) return o1 - o2;
                else return Math.abs(o1) - Math.abs(o2);
            }
        });

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(br.readLine());

            if (n != 0) pq.add(n);
            else {
                if (!pq.isEmpty()) sb.append(pq.poll()).append("\n");
                else sb.append(0).append("\n");
            }
        }

        System.out.println(sb);
    }
}