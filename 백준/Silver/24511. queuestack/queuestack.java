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
		int N = Integer.parseInt(br.readLine());
		int[] qscheck = new int[N]; // queuestack에 있는 큐, 스택 구분
		Deque<Integer> queuestack = new ArrayDeque<>(); // queuestack 생성
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			qscheck[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int a = Integer.parseInt(st.nextToken());
			if (qscheck[i] == 0) // 스택은 아무 변화가 없기 때문에 큐에 들어가는 값만 넣는다.
				queuestack.addFirst(a);
		}
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			queuestack.add(Integer.parseInt(st.nextToken()));
			sb.append(queuestack.poll()).append(" "); // 큐는 선입선출
		}
		System.out.println(sb);
	}
}