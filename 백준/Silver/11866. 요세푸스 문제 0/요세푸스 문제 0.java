import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		Queue<Integer> queue = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			queue.add(i + 1);
		}
		int cnt = 1;
		System.out.print("<");
		// 요세푸스 순열 구하기
		while (queue.size() > 0) {
			if (cnt % K == 0 && queue.size() != 1) // K번째 사람 제거
				System.out.print(queue.poll() + "," + " ");
			else if (cnt % K == 0 && queue.size() == 1) // K번째 사람 제거
				System.out.print(queue.poll());
			else
				queue.add(queue.poll());
			cnt++;
		}
		System.out.print(">");
	}
}