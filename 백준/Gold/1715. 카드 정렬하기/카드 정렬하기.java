import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Long> nums = new PriorityQueue<>();

        for (int i = 0; i < N; i++) nums.add(Long.parseLong(br.readLine()));

        long min = 0; // 최소 횟수

        while (nums.size() > 1) {
            long A = nums.poll();
            long B = nums.poll();

            min += A + B;
            nums.add(A + B);
        }

        System.out.println(min);
    }
}