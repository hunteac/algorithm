import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		Deque<Integer> deque = new LinkedList<>();
		int N = Integer.parseInt(st.nextToken());
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());
			switch(M) {
			case 1: // 정수 X를 덱의 앞에 넣는다. 
				deque.addFirst(Integer.parseInt(st.nextToken()));
				break;
			case 2: // 정수 X를 덱의 뒤에 넣는다. 
				deque.addLast(Integer.parseInt(st.nextToken()));
				break;
			case 3: // 덱에 정수가 있다면 맨 앞의 정수를 빼고 출력한다. 없다면 -1을 대신 출력한다.
				if (!deque.isEmpty())
					sb.append(deque.poll()).append("\n");
				else
					sb.append(-1).append("\n");
				break;
			case 4: // 덱에 정수가 있다면 맨 뒤의 정수를 빼고 출력한다. 없다면 -1을 대신 출력한다.
				if (!deque.isEmpty())
					sb.append(deque.pollLast()).append("\n");
				else
					sb.append(-1).append("\n");
				break;
			case 5: // 덱에 들어있는 정수의 개수를 출력한다.
				sb.append(deque.size()).append("\n");
				break;
			case 6: // 덱이 비어있으면 1, 아니면 0을 출력한다.
				if (deque.isEmpty())
					sb.append(1).append("\n");
				else
					sb.append(0).append("\n");
				break;
			case 7: // 덱에 정수가 있다면 맨 앞의 정수를 출력한다. 없다면 -1을 대신 출력한다.
				if (!deque.isEmpty())
					sb.append(deque.peek()).append("\n");
				else
					sb.append(-1).append("\n");
				break;
			case 8: // 덱에 정수가 있다면 맨 뒤의 정수를 출력한다. 없다면 -1을 대신 출력한다.
				if (!deque.isEmpty())
					sb.append(deque.peekLast()).append("\n");
				else
					sb.append(-1).append("\n");
				break;
			}
		}
		System.out.println(sb);
	}
}