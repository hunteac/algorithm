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
		Deque<int[]> balloon = new ArrayDeque<>();
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		// 첫 번째 풍선 터뜨리기
		sb.append(1).append(" ");
		int in = arr[0];
		
		for (int i = 1; i < N; i++) {
			balloon.add(new int[] {(i + 1), arr[i]});
		}
		// 나머지 풍선 터뜨리기
		while (!balloon.isEmpty()) {
			// 원 오른쪽 이동
			if (in > 0) { 
				for (int i = 1; i < in; i++) {
					balloon.add(balloon.poll());
					
				}
				int[] next = balloon.poll();
				in = next[1];
				sb.append(next[0]).append(" ");
			// 원 왼쪽 이동
			} else { 
				for (int i = 1; i < -in; i++) {
					balloon.addFirst(balloon.pollLast());
				}
				int[] next = balloon.pollLast();
				in = next[1];
				sb.append(next[0]).append(" ");
			}
		}
		System.out.println(sb);
	}
}