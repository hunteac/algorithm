import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		// 연결 리스트를 활용한 큐 생성
		LinkedList<Integer> queue = new LinkedList<>();
		// 명령 수
		int N = Integer.parseInt(br.readLine());
		// 명령 수 만큼 반복문 실행
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			// 명령 입력
			String s = st.nextToken();
			// push X: 정수 X를 큐에 넣는 연산이다.
			if (s.equals("push")) {
				int X = Integer.parseInt(st.nextToken());
				queue.add(X);
			// pop: 큐에서 가장 앞에 있는 정수를 빼고, 그 수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
			} else if (s.equals("pop")) {
				if (!queue.isEmpty())
					sb.append(queue.poll()).append("\n");
				else
					sb.append(-1).append("\n");
			// size: 큐에 들어있는 정수의 개수를 출력한다.
			} else if (s.equals("size")) {
				sb.append(queue.size()).append("\n");
			// empty: 큐가 비어있으면 1, 아니면 0을 출력한다.
			} else if (s.equals("empty")) {
				if (queue.isEmpty())
					sb.append(1).append("\n");
				else
					sb.append(0).append("\n");
			// front: 큐의 가장 앞에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
			} else if (s.equals("front")) {
				if (!queue.isEmpty())
					sb.append(queue.peek()).append("\n");
				else
					sb.append(-1).append("\n");
			// back: 큐의 가장 뒤에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
			} else if (s.equals("back")) {
				if (!queue.isEmpty()) {
					sb.append(queue.get(queue.size() - 1)).append("\n");
				} else
					sb.append(-1).append("\n");
			}
		}
		System.out.println(sb);
	}
}