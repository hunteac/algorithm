import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		Deque<Integer> deq = new ArrayDeque<>();
		int N = Integer.parseInt(br.readLine());
		int num = 0;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String command = st.nextToken();
			
			switch (command) {
				case "push_front":
					num = Integer.parseInt(st.nextToken());
					deq.addFirst(num);
					break;
				case "push_back":
					num = Integer.parseInt(st.nextToken());
					deq.addLast(num);
					break;
				case "pop_front":
					if (deq.isEmpty()) sb.append(-1).append("\n");
					else sb.append(deq.pollFirst()).append("\n");
					break;
				case "pop_back":
					if (deq.isEmpty()) sb.append(-1).append("\n");
					else sb.append(deq.pollLast()).append("\n");
					break;
				case "size":
					sb.append(deq.size()).append("\n");
					break;
				case "empty":
					if (deq.isEmpty()) sb.append(1).append("\n");
					else sb.append(0).append("\n");
					break;
				case "front":
					if (deq.isEmpty()) sb.append(-1).append("\n");
					else sb.append(deq.peekFirst()).append("\n");
					break;
				case "back":
					if (deq.isEmpty()) sb.append(-1).append("\n");
					else sb.append(deq.peekLast()).append("\n");
					break;
			}
		}
		
		System.out.println(sb);
	}
}