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
		
		int M = Integer.parseInt(br.readLine());
		int num = 0;
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			String command = st.nextToken();
			
			switch (command) {
				case "add":
					num = Integer.parseInt(st.nextToken());
					deq.add(num);
					break;
				case "remove":
					num = Integer.parseInt(st.nextToken());
					if (deq.contains(num)) deq.remove(num);
					break;
				case "check":
					num = Integer.parseInt(st.nextToken());
					if (deq.contains(num)) sb.append(1).append("\n");
					else sb.append(0).append("\n");
					break;
				case "toggle":
					num = Integer.parseInt(st.nextToken());
					if (deq.contains(num)) deq.remove(num); 
					else deq.add(num);
					break;
				case "all":
					for (int j = 1; j <= 20; j++) {
						if (deq.contains(j)) continue;
						deq.add(j);
					}
					break;
				case "empty":
					deq.clear();
					break;
			}
		}
		
		System.out.println(sb);
	}
}