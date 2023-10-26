import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		Queue<Integer> queue = new LinkedList<>();
		int N = Integer.parseInt(br.readLine());
		
		int num = 0;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String command = st.nextToken();
			
			switch (command) {
				case "push":
					num = Integer.parseInt(st.nextToken());
					queue.add(num);
					break;
				case "pop":
					if (!queue.isEmpty()) sb.append(queue.poll()).append("\n");
					else sb.append(-1).append("\n");
					break;
				case "size":
					sb.append(queue.size()).append("\n");
					break;
				case "empty":
					if (!queue.isEmpty()) sb.append(0).append("\n");
					else sb.append(1).append("\n");
					break;
				case "front":
					if (!queue.isEmpty()) sb.append(queue.peek()).append("\n");
					else sb.append(-1).append("\n");
					break;
				case "back":
					if (!queue.isEmpty()) sb.append(num).append("\n");
					else sb.append(-1).append("\n");
					break;
			}
		}
		
		System.out.println(sb);
	}
}