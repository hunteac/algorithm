import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		// 내림차순 정렬 우선순위 큐
		PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2 - o1;
			}
		});
		
		for (int i = 0; i < N; i++) {
			int order = Integer.parseInt(br.readLine());
			if (order == 0) {
				if (pq.isEmpty()) sb.append(0).append("\n");
				else sb.append(pq.poll()).append("\n");
			} else {
				pq.add(order);
			}
		}
		
		System.out.println(sb);
	}
}